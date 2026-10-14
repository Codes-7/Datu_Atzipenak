package paagbi.repository;

import java.io.FileWriter;
import java.io.IOException;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonWriter;
import paagbi.model.ArriskuEremua;
import paagbi.model.ErreskateTaldea;
import paagbi.model.Koordenatua;
import paagbi.model.Larrialdia;
import paagbi.model.Misioa;
import paagbi.model.Misioak;
import jakarta.json.JsonArrayBuilder;

public class JsonMisioaRepository {

    public void jsoneraEsportatu(Misioak misioak) {
        // Misio guztiak gordetzeko JSON array-a sortzen dugu.
        JsonArrayBuilder misioakArray = Json.createArrayBuilder();

        // Misio guztiak banan-banan aztertzen ditugu.
        for (Misioa misioa : misioak.getMisioak()) {
            // Misio bakoitzerako JSON objektu bat sortzen dugu.
            JsonObjectBuilder misioaJson = Json.createObjectBuilder()
                    .add("id", misioa.getId())
                    .add("izena", misioa.getIzena());
            // Erreskate taldeak gordetzeko array-a sortzen dugu.
            JsonArrayBuilder taldeakArray = Json.createArrayBuilder();
            for (ErreskateTaldea taldea : misioa.getErreskateTaldeak()) {
                // Taldearen koordenatua JSON objektu batean gordetzen dugu.
                JsonObjectBuilder koordenatuaJson = Json.createObjectBuilder()
                        .add("latitude", taldea.getKoordenatua().getLatitude())
                        .add("longitude", taldea.getKoordenatua().getLongitude());
                // Erreskate taldea JSON objektu batean gordetzen dugu.
                JsonObjectBuilder taldeaJson = Json.createObjectBuilder()
                        .add("id", taldea.getId())
                        .add("izena", taldea.getIzena())
                        .add("mota", taldea.getMota())
                        .add("koordenatua", koordenatuaJson);
                taldeakArray.add(taldeaJson);
            }

            // Erreskate taldeen array-a misioari gehitzen diogu.
            misioaJson.add("erreskateTaldeak", taldeakArray);
            // Larrialdiak gordetzeko array-a sortzen dugu.
            JsonArrayBuilder larrialdiakArray = Json.createArrayBuilder();
            for (Larrialdia larrialdia : misioa.getLarrialdiak()) {
                // Larrialdiaren koordenatua JSON objektu batean gordetzen dugu.
                JsonObjectBuilder koordenatuaJson = Json.createObjectBuilder()
                        .add("latitude", larrialdia.getKoordenatua().getLatitude())
                        .add("longitude", larrialdia.getKoordenatua().getLongitude());
                // Larrialdia JSON objektu batean gordetzen dugu.
                JsonObjectBuilder larrialdiaJson = Json.createObjectBuilder()
                        .add("id", larrialdia.getId())
                        .add("izena", larrialdia.getIzena())
                        .add("larritasuna", larrialdia.getLarritasuna())
                        .add("koordenatua", koordenatuaJson);
                larrialdiakArray.add(larrialdiaJson);
            }
            // Larrialdien array-a misioari gehitzen diogu.
            misioaJson.add("larrialdiak", larrialdiakArray);

            // Arrisku eremuak gordetzeko array-a sortzen dugu.
            JsonArrayBuilder arriskuEremuakArray = Json.createArrayBuilder();
            for (ArriskuEremua arriskuEremua : misioa.getArriskuEremuak()) {
                // Arrisku eremuko koordenatu guztiak gordetzeko array-a.
                JsonArrayBuilder koordenatuakArray = Json.createArrayBuilder();
                for (Koordenatua koordenatua : arriskuEremua.getKoordenatuak()) {
                    JsonObjectBuilder koordenatuaJson = Json.createObjectBuilder()
                            .add("latitude", koordenatua.getLatitude())
                            .add("longitude", koordenatua.getLongitude());
                    koordenatuakArray.add(koordenatuaJson);
                }

                // Arrisku eremua JSON objektu batean gordetzen dugu.
                JsonObjectBuilder arriskuEremuaJson = Json.createObjectBuilder()
                        .add("id", arriskuEremua.getId())
                        .add("izena", arriskuEremua.getIzena())
                        .add("mota", arriskuEremua.getMota())
                        .add("koordenatuak", koordenatuakArray);

                arriskuEremuakArray.add(arriskuEremuaJson);
            }

            // Arrisku eremuen array-a misioari gehitzen diogu.
            misioaJson.add("arriskuEremuak", arriskuEremuakArray);

            // Misioa misioen array nagusira gehitzen dugu.
            misioakArray.add(misioaJson);
        }

        // JSON objektu nagusia sortzen dugu.
        JsonObject json = Json.createObjectBuilder()
                .add("misioak", misioakArray)
                .build();

        // JSON objektua fitxategian idazten dugu.
        try (FileWriter file = new FileWriter("src/main/resources/json/misioak.json");
            JsonWriter writer = Json.createWriter(file)) {
            writer.writeObject(json);
            System.out.println("JSON fitxategia ondo esportatu da.");

        } catch (IOException e) {
            System.err.println("Errorea JSON fitxategia esportatzean: "
                    + e.getMessage());
        }
    }
}
