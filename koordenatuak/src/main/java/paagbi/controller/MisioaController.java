package paagbi.controller;

import java.util.List;

import paagbi.model.ArriskuEremua;
import paagbi.model.ErreskateTaldea;
import paagbi.model.Koordenatua;
import paagbi.model.Larrialdia;
import paagbi.model.Misioa;
import paagbi.model.Misioak;
import paagbi.view.MisioaView;

public class MisioaController {
    private Misioak misioak;
    private MisioaView view;

    public MisioaController(Misioak misioak, MisioaView view) {
        this.misioak = misioak;
        this.view = view;
    }

    /**
     * Programaren menu nagusia kontrolatzen du.
     */
    public void programaExekutatu() {
        int aukera;
        do {
            aukera = view.menu();
            switch (aukera) {
                case 1:
                    jolastu();
                    break;
                case 2:
                    view.mezuaErakutsi("JSON esportazioa oraindik ez dago erabilgarri.");
                    break;
                case 3:
                    view.mezuaErakutsi("JSON inportazioa oraindik ez dago erabilgarri.");
                    break;
                case 0:
                    view.mezuaErakutsi("Agur!");
                    break;
                default:
                    view.mezuaErakutsi("Aukera ez da zuzena.");
            }
        } while (aukera != 0);
    }

    /**
     * Misio Reskatea jokoaren partida kontrolatzen du.
     */
    private void jolastu() {
        // Misioen zerrenda lortzen dugu.
        List<Misioa> misioZerrenda = misioak.getMisioak();

        // Erabiltzaileari misio bat aukeratzeko eskatzen diogu.
        int misioAukera = view.misioaAukeratu(misioZerrenda);

        // Menuan 1etik hasten garenez, List-aren posiziora egokitzen dugu.
        Misioa misioa = misioZerrenda.get(misioAukera - 1);

        // Aukeratutako misioaren larrialdiak lortzen ditugu.
        List<Larrialdia> larrialdiak = misioa.getLarrialdiak();
        
        // Erabiltzaileari larrialdi bat aukeratzeko eskatzen diogu.
        int larrialdiAukera = view.larrialdiaAukeratu(larrialdiak);
        Larrialdia larrialdia = larrialdiak.get(larrialdiAukera - 1);

        // Lehenengo erronka: gertuen dagoen erreskate taldea aukeratzea.
        List<ErreskateTaldea> taldeak = misioa.getErreskateTaldeak();
        int taldeAukera = view.taldeaAukeratu(taldeak);
        ErreskateTaldea erabiltzailearenTaldea = taldeak.get(taldeAukera - 1);

        // Benetan gertuen dagoen taldea kalkulatzen dugu.
        ErreskateTaldea gertuenekoTaldea = gertuenekoTaldeaBilatu(larrialdia, taldeak);

        // Erabiltzailearen erantzuna egiaztatzen dugu.
        if (erabiltzailearenTaldea == gertuenekoTaldea) {
            view.zuzenaErakutsi();
        } else {
            view.okerraErakutsi();
            view.mezuaErakutsi(
                    "Gertueneko taldea: " + gertuenekoTaldea.getIzena()
            );
        }

        // Bigarren erronka: larrialdia arrisku eremuan dagoen asmatzea.
        if (!misioa.getArriskuEremuak().isEmpty()) {
            ArriskuEremua arriskuEremua = misioa.getArriskuEremuak().get(0);

            boolean erabiltzailearenErantzuna = view.arriskuEremuaGaldetu(larrialdia, arriskuEremua) == 1;

            boolean barruanDago = arriskuEremuanDago(larrialdia, arriskuEremua);

            if (erabiltzailearenErantzuna == barruanDago) {
                view.zuzenaErakutsi();
            } else {
                view.okerraErakutsi();
                if (barruanDago) {
                    view.mezuaErakutsi(
                            "Larrialdia arrisku eremuaren barruan dago."
                    );
                } else {
                    view.mezuaErakutsi(
                            "Larrialdia arrisku eremutik kanpo dago."
                    );
                }
            }
        }
    }

    //Calcular distancia entre coordenadas.   
    public double distantziaKalkulatu(Koordenatua koordenada1, Koordenatua koordenada2){
    // Bi koordenadeen latitudea eta longitudea lortzen dugu.
    double lat1 = koordenada1.getLatitude();
    double lon1 = koordenada1.getLongitude();
    double lat2 = koordenada2.getLatitude();
    double lon2 = koordenada2.getLongitude();

    // Bien arteko aldea kalkulatzen dugu.
    double dLat = lat2 - lat1;
    double dLon = lon2 - lon1;

    //
    double distantzia = Math.sqrt(
            Math.pow(dLat, 2) + Math.pow(dLon, 2)
    );
    return distantzia;
    }
    
    //Buscar el equipo más cercano.
    public ErreskateTaldea gertuenekoTaldeaBilatu(Larrialdia larrialdia, List<ErreskateTaldea>taldeak){
        ErreskateTaldea gertu = null;
        // Distantzia handiena hasierako balio bezala ezartzen dugu.
        double distantziaTxiki = Double.MAX_VALUE;

        for (ErreskateTaldea taldea : taldeak){
            // Larrialdiaren eta taldearen arteko distantzia kalkulatzen dugu.
            double distantzia = distantziaKalkulatu(larrialdia.getKoordenatua(), taldea.getKoordenatua());
            //Kalkulatu zein den gertuen dagoen taldea.
            if (distantzia < distantziaTxiki){
                distantziaTxiki = distantzia;
                gertu = taldea;
            }
        }
        return gertu;
    }

    //Comprobar si una emergencia está en zona de riesgo.
    public boolean arriskuEremuanDago(Larrialdia larrialdia, ArriskuEremua arriskuEremua){
        // Larrialdiaren koordenatua lortzen dugu.
        Koordenatua puntua = larrialdia.getKoordenatua();

        // Arrisku eremua osatzen duten koordenatuak lortzen ditugu.
        List<Koordenatua> koordenatuak = arriskuEremua.getKoordenatuak();

        // Hasierako balioak ezartzen ditugu.
        double latMin = Double.MAX_VALUE;
        double latMax = -Double.MAX_VALUE;
        double lonMin = Double.MAX_VALUE;
        double lonMax = -Double.MAX_VALUE;

        // Koordenada guztiak aztertzen ditugu lon eta lat min eta max aurkitzeko.
        for (Koordenatua koordenatua : koordenatuak) {
            if (koordenatua.getLatitude() < latMin) {
                latMin = koordenatua.getLatitude();
            }
            if (koordenatua.getLatitude() > latMax) {
                latMax = koordenatua.getLatitude();
            }
            if (koordenatua.getLongitude() < lonMin) {
                lonMin = koordenatua.getLongitude();
            }
            if (koordenatua.getLongitude() > lonMax) {
                lonMax = koordenatua.getLongitude();
            }
        }

        if (puntua.getLatitude() >= latMin
                && puntua.getLatitude() <= latMax
                && puntua.getLongitude() >= lonMin
                && puntua.getLongitude() <= lonMax) {

            return true;
        } else {
            return false;
        }
    }

    //Controlar la lógica de la misión.


}
