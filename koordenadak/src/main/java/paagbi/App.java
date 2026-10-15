package paagbi;
import paagbi.view.HasieraView;

/**
 * Aplikazioaren exekuzio puntua.
 *
 * Hasierako leihoa sortzen du eta erabiltzaileari jokoaren menu nagusia erakusten dio.
 *
 * @author Maider Santesteban
 */
public class App 
{
    /**
     * Programa abiarazten duen metodo nagusia.
     *
     * @param args komando lerroko argumentuak
     */
    public static void main( String[] args ){
        HasieraView view = new HasieraView();
        view.setVisible(true);
    }
}
