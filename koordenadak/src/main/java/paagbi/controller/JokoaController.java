package paagbi.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonException;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;
import paagbi.model.ArriskuEremua;
import paagbi.model.Jokoa;
import paagbi.model.Kokalekua;
import paagbi.model.Puntuazioa;
import paagbi.repository.XmlKudeatzailea;

/**
 * Jokoaren logika nagusia kudeatzen duen kontrolatzailea.
 *
 * XML fitxategitik datuak kargatzen ditu eta jokoareneragiketa desberdinak eskaintzen ditu.
 *
 * @author Maider Santesteban
 */
public class JokoaController {

    private Jokoa jokoa;

    /**
     * Jokoaren datuak XML fitxategitik kargatzen ditu eta kontrolatzailea prestatzen du.
     */
    public JokoaController() {
        XmlKudeatzailea xml = new XmlKudeatzailea();
        jokoa = xml.kargatuJokoa();
    }

    /**
     * Jokoan erabilgarri dauden kokaleku guztiak itzultzen ditu.
     *
     * @return kokalekuen zerrenda
     */
    public List<Kokalekua> getKokalekuak() {
        return jokoa.getKokalekuak();
    }

    /**
     * Jokoan erabiliko den ausazko kokaleku bat aukeratzen du.
     *
     * Kokalekuen zerrendatik elementu bat ausaz hautatzen da. Kokalekurik ez badago, null itzultzen da.
     *
     * @return ausaz aukeratutako kokalekua edo null zerrenda hutsik badago
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
     * Erabiltzailearen erantzuna zuzena den egiaztatzen du.
     *
     * @param zuzena kokaleku zuzena
     * @param erantzuna erabiltzailearen erantzuna
     * @return true erantzuna zuzena bada, false bestela
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
     * Emandako kokalekutik hurbilen dagoen beste kokalekua bilatzen du.
     *
     * @param kokalekua erreferentziazko kokalekua
     * @return hurbilen dagoen kokalekua
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
     * Kokaleku bat arrisku eremu baten barruan dagoen egiaztatzen du.
     *
     * @param k egiaztatu beharreko kokalekua
     * @param eremua arrisku eremua
     * @return true barruan badago, false bestela
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

    /**
     * Jokoan erabilgarri dagoen lehen arrisku eremua itzultzen du.
     *
     * @return arrisku eremua edo null ez badago
     */
    public ArriskuEremua getArriskuEremua() {

        if (jokoa.getArriskuEremuak() == null
                || jokoa.getArriskuEremuak().isEmpty()) {
            return null;
        }

        return jokoa.getArriskuEremuak().get(0);
    }

    /**
     * Jokalariaren puntuazioa JSON fitxategi batera esportatzen du.
     *
     * Puntuazio berria lehendik dauden erregistroei gehitzen zaie.
     *
     * @param puntuazioa esportatu beharreko puntuazioa
     */
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
        } catch (IOException e) {
            System.err.println("Errorea fitxategia irakurtzean edo idaztean.");
            e.printStackTrace();
        } catch (JsonException e) {
            System.err.println("Errorea JSON formatua prozesatzean.");
            e.printStackTrace();
        }
    }
}
