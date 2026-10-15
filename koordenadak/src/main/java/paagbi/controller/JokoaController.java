package paagbi.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;
import paagbi.model.ArriskuEremua;
import paagbi.model.Jokoa;
import paagbi.model.Kokalekua;
import paagbi.model.Puntuazioa;
import paagbi.repository.XmlKudeatzailea;

public class JokoaController {

    private Jokoa jokoa;

    /**
     * 
     */
    public JokoaController() {
        XmlKudeatzailea xml = new XmlKudeatzailea();
        jokoa = xml.kargatuJokoa();
    }

    /**
     * 
     * @return
     */
    public List<Kokalekua> getKokalekuak() {
        return jokoa.getKokalekuak();
    }

    /**
     * Elije un sitio de manera aleatoria.
     * @return
     */
    public Kokalekua ausazkoKokalekua() {
        //Comprobamos que la lista no está vacía.
        if (jokoa.getKokalekuak() == null || jokoa.getKokalekuak().isEmpty()) {
        return null;
        }
        Random random = new Random();
        int posizioa = random.nextInt(jokoa.getKokalekuak().size());

        Kokalekua kokalekua = jokoa.getKokalekuak().get(posizioa);
        return kokalekua;
    }

    /**
     * 
     * @param zuzena
     * @param erantzuna
     * @return
     */
    public boolean egiaztatuErantzuna(Kokalekua zuzena, String erantzuna) {
        boolean zuzenaDa = zuzena.getIzena().equalsIgnoreCase(erantzuna);
        return zuzenaDa;
    }

    /**
     * Bi kokalekuren arteko distantzia kalkulatzen du.
     * 
     * @param k1 lehen kokalekua
     * @param k2 bigarren kokalekua
     * @return distantzia
     */
    public double distantziaKalkulatu(Kokalekua k1, Kokalekua k2) {
        //Lehenengo puntuko koordenadak.
        double lat1 = k1.getKoordenatua().getLatitude();
        double lon1 = k1.getKoordenatua().getLongitude();
        //Bigarren puntuko koordenadak.
        double lat2 = k2.getKoordenatua().getLatitude();
        double lon2 = k2.getKoordenatua().getLongitude();
        //Koordenaden arteko desberdintasuna.
        double latDesberdintasuna = lat2 - lat1;
        double lonDesberdintasuna = lon2 - lon1;
        //Distantzia kalkulatzen dugu.
        double distantzia = Math.sqrt(Math.pow(latDesberdintasuna, 2) + Math.pow(lonDesberdintasuna, 2));

        return distantzia;
    }

    /**
     * 
     * 
     * @param kokalekua
     * @return
     */
    public Kokalekua hurbilenDagoenaBilatu(Kokalekua kokalekua) {
        //Comprobamos que la lista no esté vacía.
         if (jokoa.getKokalekuak() == null ||
        jokoa.getKokalekuak().isEmpty()) {
        return null;
        }

        Kokalekua hurbilenekoa = null;
        double distantziaTxikiena = Double.MAX_VALUE;

        for (Kokalekua k : jokoa.getKokalekuak()) {
            if (k.getId() != kokalekua.getId()) {
                double distantzia = distantziaKalkulatu(kokalekua, k);
                if (distantzia < distantziaTxikiena) {
                    distantziaTxikiena = distantzia;
                    hurbilenekoa = k;
                }
            }
        }
        return hurbilenekoa;
    }

    /**
     * 
     * 
     * @param k
     * @param eremua
     * @return
     */
    public boolean arriskuEremuanDago(Kokalekua k, ArriskuEremua eremua) {
        double latitude = k.getKoordenatua().getLatitude();
        double longitude = k.getKoordenatua().getLongitude();

        if (latitude >= eremua.getLatMin()
                && latitude <= eremua.getLatMax()
                && longitude >= eremua.getLonMin()
                && longitude <= eremua.getLonMax()) {
            return true;
        }
        return false;
    }

    public ArriskuEremua getArriskuEremua() {

        if (jokoa.getArriskuEremuak() == null
                || jokoa.getArriskuEremuak().isEmpty()) {
            return null;
        }

        return jokoa.getArriskuEremuak().get(0);
    }

   public void jsoneraEsportatu(Puntuazioa puntuazioa) {
        File fitxategia = new File("koordenadak/src/main/resources/json/puntuazioa.json");
        JsonObject puntuazioBerria = Json.createObjectBuilder()
            .add("jokalaria", puntuazioa.getJokalaria())
            .add("puntuak",puntuazioa.getPuntuak())
            .build();
        try {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            // Si ya existe, leer las puntuaciones antiguas
            if (fitxategia.exists() && fitxategia.length() > 0) {
                try (JsonReader reader = Json.createReader(new FileReader(fitxategia))) {
                    JsonArray array = reader.readArray();
                    for (JsonValue balioa : array) {
                        arrayBuilder.add((JsonObject) balioa);
                    }
                }
            }
            // Añadimos la nueva puntuación
            arrayBuilder.add(puntuazioBerria);
            JsonArray arrayBerria = arrayBuilder.build();
            try (JsonWriter writer = Json.createWriter(new FileWriter(fitxategia))) {
                writer.writeArray(arrayBerria);
            }
            System.out.println("JSON fitxategia eguneratu da.");
        } catch (Exception e) {
            System.err.println("Errorea JSON esportatzean.");
            e.printStackTrace();
        }
    }
}
