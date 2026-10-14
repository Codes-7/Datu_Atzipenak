package paagbi.view;

import java.util.List;
import java.util.Scanner;

import paagbi.model.ArriskuEremua;
import paagbi.model.ErreskateTaldea;
import paagbi.model.Koordenatua;
import paagbi.model.Larrialdia;
import paagbi.model.Misioa;

public class MisioaView {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Menu nagusia erakusten du eta erabiltzailearen aukera itzultzen du.
     */
    public int menu() {
        System.out.println("\n==========================");
        System.out.println("      MISIO RESKATEA");
        System.out.println("==========================");
        System.out.println("1. Jolastu");
        System.out.println("2. JSON-era esportatu");
        System.out.println("3. JSON-tik inportatu");
        System.out.println("0. Irten");
        System.out.println("==========================");
        System.out.print("Aukeratu aukera bat: ");
        return scanner.nextInt();
    }

    /**
     * Eskuragarri dauden misioak erakusten ditu eta erabiltzaileari misio bat aukeratzeko eskatzen dio.
     */
    public int misioaAukeratu(List<Misioa> misioak) {
        System.out.println("\n===== MISIOAK =====");
        for (int i = 0; i < misioak.size(); i++) {
            System.out.println((i + 1) + ". " + misioak.get(i).getIzena());
        }
        System.out.print("Aukeratu misio bat: ");
        return scanner.nextInt();
    }

    /**
     * Aukeratutako misioaren larrialdiak erakusten ditu eta erabiltzaileari bat aukeratzeko eskatzen dio.
     */
    public int larrialdiaAukeratu(List<Larrialdia> larrialdiak) {
        System.out.println("\n===== LARRIALDIAK =====");
        for (int i = 0; i < larrialdiak.size(); i++) {
            Larrialdia larrialdia = larrialdiak.get(i);
            System.out.println(
                    (i + 1) + ". " + larrialdia.getIzena()
                    + " - (" 
                    + larrialdia.getKoordenatua().getLatitude()
                    + ", "
                    + larrialdia.getKoordenatua().getLongitude()
                    + ")"
            );
        }
        System.out.print("Aukeratu larrialdi bat: ");
        return scanner.nextInt();
    }

    /**
     * Eskuragarri dauden erreskate taldeak erakusten ditu eta erabiltzaileari gertuen dagoena aukeratzeko eskatzen dio.
     */
    public int taldeaAukeratu(List<ErreskateTaldea> taldeak) {
        System.out.println("\n===== ERRESKATE TALDEAK =====");
        for (int i = 0; i < taldeak.size(); i++) {
            ErreskateTaldea taldea = taldeak.get(i);
            System.out.println(
                    (i + 1) + ". " + taldea.getIzena()
                    + " - ("
                    + taldea.getKoordenatua().getLatitude()
                    + ", "
                    + taldea.getKoordenatua().getLongitude()
                    + ")"
            );
        }
        System.out.print("Zein talde dago gertuen? ");
        return scanner.nextInt();
    }

    /**
     * Erabiltzaileari larrialdia arrisku eremuaren barruan dagoen galdetzen dio.
     */
    public int arriskuEremuaGaldetu(Larrialdia larrialdia,ArriskuEremua arriskuEremua) {
        System.out.println("\n===== ARRISKU EREMUA =====");
        // Larrialdiaren koordenatuak erakusten ditugu.
        System.out.println(
                "Larrialdia: "
                + larrialdia.getIzena()
                + " ("
                + larrialdia.getKoordenatua().getLatitude()
                + ", "
                + larrialdia.getKoordenatua().getLongitude()
                + ")"
        );
        System.out.println("\nArrisku eremuaren koordenatuak:");
        // Arrisku eremua osatzen duten puntu guztiak erakusten ditugu.
        for (Koordenatua koordenatua : arriskuEremua.getKoordenatuak()) {
            System.out.println(
                    "("
                    + koordenatua.getLatitude()
                    + ", "
                    + koordenatua.getLongitude()
                    + ")"
            );
        }
        System.out.println( "\nLarrialdia arrisku eremuaren barruan dago?");

        System.out.println("1. Bai");
        System.out.println("2. Ez");
        System.out.print("Aukeratu aukera bat: ");

        return scanner.nextInt();
    }

    /**
     * Erantzuna zuzena dela erakusten du.
     */
    public void zuzenaErakutsi() {
        System.out.println("Zuzena!");
    }

    /**
     * Erantzuna okerra dela erakusten du.
     */
    public void okerraErakutsi() {
        System.out.println("Okerra!");
    }

    /**
     * Erabiltzaileari mezu bat erakusten dio.
     */
    public void mezuaErakutsi(String mezua) {
        System.out.println(mezua);
    }
}
