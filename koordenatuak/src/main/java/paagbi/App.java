package paagbi;

import paagbi.controller.MisioaController;
import paagbi.model.Misioak;
import paagbi.repository.XmlMisioaRepository;
import paagbi.view.MisioaView;

public class App {

    public static void main(String[] args) {

        try {
            // XML fitxategiko misioak kargatzeko repository-a sortzen dugu.
            XmlMisioaRepository repository = new XmlMisioaRepository();

            // XML fitxategiko datuak Java objektuetan kargatzen ditugu.
            Misioak misioak = repository.kargatuMisioak();

            // Erabiltzailearekin komunikatzeko view-a sortzen dugu.
            MisioaView view = new MisioaView();

            // Controller-a sortzen dugu, datuak eta view-a emanez.
            MisioaController controller = new MisioaController(misioak, view);

            // Programa martxan jartzen dugu.
            controller.programaExekutatu();

        } catch (IllegalArgumentException e) {
            System.out.println("Errorea: " + e.getMessage());
        }
    }
}
