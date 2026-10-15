package paagbi.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import paagbi.controller.JokoaController;

/**
 * Aplikazioaren hasierako leihoa.
 *
 * Bertan jokalariaren izena sartzen da eta erabilgarri dauden hiru joko motetako bat aukeratzen da.
 *
 * @author Maider Santesteban
 */
public class HasieraView extends JFrame {

    private JTextField txtIzena;
    private JButton btnKoordenatuak;
    private JButton btnHurbilena;
    private JButton btnArriskua;

    /**
     * Hasierako interfazea sortzen du eta osagai grafikoak prestatzen ditu.
     */
    public HasieraView() {
        //Ajustes generales
        setTitle("Koordenatuen Erronka");
        setSize(620, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(230, 243, 255));

        JLabel lblTitulo = new JLabel("KOORDENATUEN ERRONKA");
        lblTitulo.setFont(new Font("Arial",Font.BOLD,22));
        lblTitulo.setBounds(150, 40, 320, 30);

        JLabel lblIzena = new JLabel("Jokalariaren izena:");
        lblIzena.setBounds(80, 110, 150, 25);

        txtIzena = new JTextField();
        txtIzena.setBounds(220, 110, 300, 25);

        //Botones de los juegos
        btnKoordenatuak = new JButton("Koordenatuak asmatu");
        btnKoordenatuak.setBounds(20, 170, 180, 40);
        btnKoordenatuak.setBackground(new Color(135, 206, 235));
        btnKoordenatuak.setForeground(new Color(50,50,50));

        btnHurbilena = new JButton("Hurbilen dagoena bilatu");
        btnHurbilena.setBounds(210, 170, 180, 40);
        btnHurbilena.setBackground(new Color(135, 206, 235));
        btnHurbilena.setForeground(new Color(50,50,50));

        btnArriskua = new JButton("Arriskua kalkulatu");
        btnArriskua.setBounds(400, 170, 180, 40);
        btnArriskua.setBackground(new Color(135, 206, 235));
        btnArriskua.setForeground(new Color(50,50,50));

        //Añadir los elementos al panel
        panel.add(lblTitulo);
        panel.add(lblIzena);
        panel.add(txtIzena);
        panel.add(btnKoordenatuak);
        panel.add(btnHurbilena);
        panel.add(btnArriskua);
        add(panel);

        //Acciones de los botones
        btnKoordenatuak.addActionListener(e -> {
            String jokalaria = txtIzena.getText().trim();
            if (!jokalaria.isEmpty()) {
                JokoaController controller = new JokoaController();
                JokoaView jokoaView = new JokoaView(controller, jokalaria,1);
                jokoaView.setVisible(true);
                dispose();
            }
        });

        btnHurbilena.addActionListener(e -> {
            String jokalaria = txtIzena.getText().trim();
            if (!jokalaria.isEmpty()) {
                JokoaController controller = new JokoaController();
                JokoaView view = new JokoaView(controller, jokalaria, 2);
                view.setVisible(true);
                dispose();
            }
        });

        btnArriskua.addActionListener(e -> {
            String jokalaria = txtIzena.getText().trim();
            if (!jokalaria.isEmpty()) {
                JokoaController controller = new JokoaController();
                JokoaView view = new JokoaView(controller, jokalaria, 3);
                view.setVisible(true);
                dispose();
            }
        }
    );

    }
}

