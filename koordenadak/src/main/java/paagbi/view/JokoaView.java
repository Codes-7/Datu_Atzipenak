package paagbi.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import paagbi.controller.JokoaController;
import paagbi.model.ArriskuEremua;
import paagbi.model.Kokalekua;
import paagbi.model.Puntuazioa;

/**
 * Jokoaren interfaze grafikoa kudeatzen duen klasea.
 * 
 * Hiru joko mota erakusten ditu:
 * <ul>
 *     <li>Koordenatuen arabera kokalekua asmatu.</li>
 *     <li>Koordenatuetatik hurbilen dagoen kokalekua aurkitu.</li>
 *     <li>Kokalekua arrisku eremu batean dagoen asmatu.</li>
 * </ul>
 *
 * @author Maider Santesteban
 */
public class JokoaView extends JFrame {

    private JokoaController controller;
    private String jokalaria;
    private Kokalekua kokalekuaZuzena;
    private int puntuak;
    private int jokoMota;

    private JLabel lblKoordenatuak;
    private JLabel lblLatitude;
    private JLabel lblLongitude;
    private JLabel lblArriskuEremua;
    private JLabel lblArriskuLat;
    private JLabel lblArriskuLon;
    private JLabel lblGaldera;
    private JLabel lblGaldera2;
    private JLabel lblEmaitza;
    private JLabel lblPuntuak;

    private JComboBox<String> cmbKokalekuak;

    private JButton btnEgiaztatu;
    private JButton btnBai;
    private JButton btnEz;
    private JButton btnJson;
    private JButton btnIrten;
    private JButton btnHurrengoa;
    private JButton btnHurrengoa3;

    /**
     * Jokoaren leiho nagusia sortzen du eta aukeratutako joko motaren arabera interfazea prestatzen du.
     * @param controller jokoaren logika kudeatzen duen kontrolatzailea
     * @param jokalaria jokalariaren izena
     * @param jokoMota jokatu nahi den joko mota
     */
    public JokoaView(JokoaController controller, String jokalaria, int jokoMota) {

        this.controller = controller;
        this.jokalaria = jokalaria;
        this.jokoMota = jokoMota;
        this.puntuak = 0;

        // Ajustes generales pantalla
        setTitle("Koordenatuen Erronka");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 243, 255));

        // Título
        JLabel lblTitulo = new JLabel("KOORDENATUEN ERRONKA");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(280, 10, 450, 40);

        // Panel general
        JPanel pnlJokoa = new JPanel();
        pnlJokoa.setLayout(null);
        pnlJokoa.setBounds(20, 70, 350, 480);
        pnlJokoa.setBackground(Color.WHITE);
        pnlJokoa.setBorder(BorderFactory.createTitledBorder("Jokoa"));

        // Jugador
        JLabel lblJokalaria = new JLabel("Jokalaria: " + jokalaria);
        lblJokalaria.setBounds(20, 20, 220, 25);

        // Título de coordenadas
        lblKoordenatuak = new JLabel("Koordenatuak");
        lblKoordenatuak.setFont(new Font("Arial", Font.BOLD, 16));
        lblKoordenatuak.setBounds(20, 60, 240, 25);

        // Latitud
        lblLatitude = new JLabel();
        lblLatitude.setBounds(20, 95, 240, 25);

        // Longitud
        lblLongitude = new JLabel();
        lblLongitude.setBounds(20, 120, 240, 25);

        // Límites del área de riesgo
        lblArriskuEremua = new JLabel();
        lblArriskuEremua.setBounds(20, 150, 240, 25);
        lblArriskuLat = new JLabel();
        lblArriskuLat.setBounds(20, 175, 240, 25);
        lblArriskuLon = new JLabel();
        lblArriskuLon.setBounds(20, 200, 240, 25);

        // Pregunta
        lblGaldera = new JLabel();
        lblGaldera.setBounds(20, 210, 240, 25);
        lblGaldera2 = new JLabel();
        lblGaldera2.setBounds(20, 235, 240, 25);

        // Combo de localidades
        cmbKokalekuak = new JComboBox<>();
        cmbKokalekuak.setBounds(20, 245, 290, 30);

        // Botón comprobar
        btnEgiaztatu = new JButton("Egiaztatu");
        btnEgiaztatu.setBounds(20, 290, 140, 35);
        btnEgiaztatu.setBackground(new Color(135, 206, 235));
        btnEgiaztatu.setForeground(new Color(50,50,50));

        // Botón BAI
        btnBai = new JButton("BAI");
        btnBai.setBounds(20, 275, 100, 35);
        btnBai.setBackground(new Color(168, 218, 181));
        btnBai.setForeground(new Color(50,50,50));
        btnBai.setFocusable(false);

        // Botón EZ
        btnEz = new JButton("EZ");
        btnEz.setBounds(140, 275, 100, 35);
        btnEz.setBackground(new Color(240, 190, 190));
        btnEz.setForeground(new Color(50,50,50));
        btnEz.setFocusable(false);

        //Botón hurrengo galdera
        btnHurrengoa = new JButton("Hurrengo galdera");
        btnHurrengoa.setBounds(170, 290, 140, 35);
        btnHurrengoa.setBackground(new Color(135, 206, 235));
        btnHurrengoa.setForeground(new Color(50,50,50));     

        //Botón hurrengoa juego 3
        btnHurrengoa3 = new JButton("Hurrengo galdera");
        btnHurrengoa3.setBounds(40, 315, 180, 40);
        btnHurrengoa3.setBackground(new Color(135, 206, 235));
        btnHurrengoa3.setForeground(new Color(50,50,50));  

        // Resultado
        lblEmaitza = new JLabel("Emaitza:");
        lblEmaitza.setBounds(20, 375, 250, 25);

        // Puntos
        lblPuntuak = new JLabel("Puntuak: 0");
        lblPuntuak.setFont(new Font("Arial", Font.BOLD, 16));
        lblPuntuak.setBounds(20, 415, 200, 25);

        // Añadimos todo al panel izquierdo
        pnlJokoa.add(lblJokalaria);
        pnlJokoa.add(lblKoordenatuak);
        pnlJokoa.add(lblLatitude);
        pnlJokoa.add(lblLongitude);
        pnlJokoa.add(lblArriskuEremua);
        pnlJokoa.add(lblArriskuLat);
        pnlJokoa.add(lblArriskuLon);
        pnlJokoa.add(lblGaldera);
        pnlJokoa.add(lblGaldera2);
        pnlJokoa.add(cmbKokalekuak);
        pnlJokoa.add(btnEgiaztatu);
        pnlJokoa.add(btnBai);
        pnlJokoa.add(btnEz);
        pnlJokoa.add(lblEmaitza);
        pnlJokoa.add(lblPuntuak);
        pnlJokoa.add(btnHurrengoa);
        pnlJokoa.add(btnHurrengoa3);

        // Mapa
        ImageIcon original = new ImageIcon(getClass().getResource("/img/mapa.jpg"));
        Image escalada = original.getImage().getScaledInstance(520, 480, Image.SCALE_SMOOTH);
        JLabel lblMapa = new JLabel(new ImageIcon(escalada));
        lblMapa.setBounds(400, 70, 520, 480);

        // Botón exportar JSON
        btnJson = new JButton("JSON esportatu");
        btnJson.setBounds(580, 560, 180, 35);
        btnJson.setBackground(new Color(135, 206, 235));
        btnJson.setForeground(new Color(50,50,50));

        // Botón volver
        btnIrten = new JButton("Atzera");
        btnIrten.setBounds(800, 560, 120, 35);
        btnIrten.setBackground(new Color(221, 160, 221));
        btnIrten.setForeground(new Color(50,50,50));

        panel.add(lblTitulo);
        panel.add(pnlJokoa);
        panel.add(lblMapa);
        panel.add(btnJson);
        panel.add(btnIrten);

        add(panel);

        // Cargar localidades
        kargatuKokalekuak(controller.getKokalekuak());

        // Preparamos la pantalla según el juego elegido
        prestatuJokoa();

        // Primera pregunta
        galderaBerria();

        // ACTION LISTENERS
        btnEgiaztatu.addActionListener(e -> egiaztatu());
        btnBai.addActionListener(e -> arriskuaEgiaztatu(true));
        btnEz.addActionListener(e -> arriskuaEgiaztatu(false));
        btnHurrengoa.addActionListener(e -> {
            galderaBerria();
            btnEgiaztatu.setEnabled(true);
        });
        btnHurrengoa3.addActionListener(e -> {
            galderaBerria();
            btnBai.setEnabled(true);
            btnEz.setEnabled(true);

        });


        btnJson.addActionListener(e -> {
            Puntuazioa puntuazioa = new Puntuazioa(jokalaria, puntuak);
            controller.jsoneraEsportatu(puntuazioa);
            lblEmaitza.setForeground(new Color(0, 102, 204));
            lblEmaitza.setText("JSON fitxategia sortu da");
        });
        btnIrten.addActionListener(e -> {
            dispose();
            HasieraView view = new HasieraView();
            view.setVisible(true);
        });
    }


    /**
     * Aukeratutako joko motaren arabera interfazeko osagaiak erakutsi edo ezkutatzen ditu.
     */
    private void prestatuJokoa() {
        //Aukeratutako joko motaren arabera dagokion egiaztapena egin.
        if (jokoMota == 1) {
            cmbKokalekuak.setVisible(true);
            btnEgiaztatu.setVisible(true);
            btnHurrengoa.setVisible(true);
            btnHurrengoa3.setVisible(false);
            btnBai.setVisible(false);
            btnEz.setVisible(false);
            lblArriskuLat.setVisible(false);
            lblArriskuLon.setVisible(false);
        }
        else if (jokoMota == 2) {
            cmbKokalekuak.setVisible(true);
            btnEgiaztatu.setVisible(true);
            btnHurrengoa.setVisible(true);
            btnHurrengoa3.setVisible(false);
            btnBai.setVisible(false);
            btnEz.setVisible(false);
            lblArriskuLat.setVisible(false);
            lblArriskuLon.setVisible(false);
        }
        else if (jokoMota == 3) {
            cmbKokalekuak.setVisible(false);
            btnEgiaztatu.setVisible(false);
            btnHurrengoa.setVisible(false);
            btnHurrengoa3.setVisible(true);
            btnBai.setVisible(true);
            btnEz.setVisible(true);
            lblArriskuLat.setVisible(true);
            lblArriskuLon.setVisible(true);
        }
    }

    /**
     * Ausazko galdera berri bat prestatzen du joko motaren arabera.
     */
    private void galderaBerria() {
        kokalekuaZuzena = controller.ausazkoKokalekua();
        if (kokalekuaZuzena == null) {
            return;
        }
        lblEmaitza.setText("Emaitza:");
        lblEmaitza.setForeground(Color.BLACK);

        //Lehenengo jolasa
        if (jokoMota == 1) {
            lblKoordenatuak.setText("Koordenatuak");
            lblLatitude.setText("Latitude: "+ kokalekuaZuzena.getKoordenatua().getLatitude());
            lblLongitude.setText("Longitude: "+ kokalekuaZuzena.getKoordenatua().getLongitude());
            lblGaldera.setText("Zein herri da?");
        }

        //Bigarren jolasa
        else if (jokoMota == 2) {
            lblKoordenatuak.setText("Koordenatuak");
            lblLatitude.setText("Latitude: "+ kokalekuaZuzena.getKoordenatua().getLatitude());
            lblLongitude.setText("Longitude: "+ kokalekuaZuzena.getKoordenatua().getLongitude());
            lblGaldera.setText("Zein da hurbilen dagoena?");
        }

        //Hirugarren jolasa
        else if (jokoMota == 3) {
            ArriskuEremua eremua = controller.getArriskuEremua();
            lblKoordenatuak.setText("Kokalekua: " + kokalekuaZuzena.getIzena());
            // Coordenadas del punto
            lblLatitude.setText("Latitude: "+ kokalekuaZuzena.getKoordenatua().getLatitude());
            lblLongitude.setText("Longitude: "+ kokalekuaZuzena.getKoordenatua().getLongitude());
            // Límites del área de riesgo
            if (eremua != null) {
                lblArriskuEremua.setText("Arrisku eremua:");
                lblArriskuLat.setText("Latitudea: "+ eremua.getLatMin()+ " - "+ eremua.getLatMax());
                lblArriskuLon.setText("Longitudea: "+ eremua.getLonMin()+ " - "+ eremua.getLonMax());
            }
            lblGaldera2.setText("Arrisku eremuan dago?");
        }
    }

    /**
     * Lehenengo eta bigarren jokoetako erabiltzailearen erantzuna egiaztatzen du.
     */
    private void egiaztatu() {
        if (jokoMota == 1) {
            koordenatuakEgiaztatu();
        } else if (jokoMota == 2) {
            hurbilenaEgiaztatu();
        }
        lblPuntuak.setText("Puntuak: " + puntuak);
        btnEgiaztatu.setEnabled(false);
    }

    /**
     * Koordenatuen jokoan aukeratutako kokalekua zuzena den egiaztatzen du.
     */
    private void koordenatuakEgiaztatu() {
        String erantzuna = (String) cmbKokalekuak.getSelectedItem();
        boolean zuzena = controller.egiaztatuErantzuna(kokalekuaZuzena,erantzuna);
        if (zuzena) {
            puntuak += 10;
            lblEmaitza.setForeground(new Color(74, 124, 89));
            lblEmaitza.setText("ZUZENA");
        } else {
            lblEmaitza.setForeground(new Color(186, 104, 104));
            lblEmaitza.setText("OKERRA. Zuzena: "+ kokalekuaZuzena.getIzena());
        }
    }

    /**
     * Erabiltzaileak aukeratutako kokalekua hurbilena den egiaztatzen du.
     */
    private void hurbilenaEgiaztatu() {
        String erantzuna = (String) cmbKokalekuak.getSelectedItem();
        Kokalekua hurbilena = controller.hurbilenDagoenaBilatu(kokalekuaZuzena);
        if (hurbilena == null) {
            return;
        }
        if (hurbilena.getIzena().equalsIgnoreCase(erantzuna)) {
            puntuak += 10;
            lblEmaitza.setForeground(new Color(0, 120, 0));
            lblEmaitza.setText("ZUZENA");
        } else {
            lblEmaitza.setForeground(Color.RED);
            lblEmaitza.setText("OKERRA. Zuzena: "+ hurbilena.getIzena());
        }
    }

    /**
     * Kokalekua arrisku eremuan dagoen egiaztatzen du erabiltzailearen erantzunarekin alderatuz.
     * @param erantzuna erabiltzaileak BAI aukeratu badu true, eta EZ aukeratu badu false
     */
    private void arriskuaEgiaztatu(boolean erantzuna) {
        ArriskuEremua eremua = controller.getArriskuEremua();
        if (eremua == null) {
            lblEmaitza.setForeground(Color.RED);
            lblEmaitza.setText("Ez dago arrisku eremurik");
            return;
        }
        boolean arriskuanDago = controller.arriskuEremuanDago(kokalekuaZuzena,eremua);
        if (erantzuna == arriskuanDago) {
            puntuak += 10;
            lblEmaitza.setForeground(new Color(0, 120, 0));
            lblEmaitza.setText("ZUZENA");
        } else {
            lblEmaitza.setForeground(Color.RED);
            if (arriskuanDago) {
                lblEmaitza.setText("OKERRA. Zuzena: BAI");
            } else {
                lblEmaitza.setText("OKERRA. Zuzena: EZ");
            }
        }
        lblPuntuak.setText("Puntuak: " + puntuak);
        btnBai.setEnabled(false);
        btnEz.setEnabled(false);
    }

    /**
     * XML fitxategitik kargatutako kokalekuak JComboBox osagaian sartzen ditu.
     * @param kokalekuak jokoan erabiliko diren kokalekuen zerrenda
     */
    private void kargatuKokalekuak(List<Kokalekua> kokalekuak) {
        cmbKokalekuak.removeAllItems();
        for (Kokalekua kokalekua : kokalekuak) {
            cmbKokalekuak.addItem(kokalekua.getIzena());
        }
    }
}
