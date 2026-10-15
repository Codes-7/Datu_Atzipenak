package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Puntuazioa {
    //===== ATRIBUTOS =====
    @XmlElement(name = "jokalaria")
    private String jokalaria;
    @XmlElement(name = "puntuak")
    private int puntuak;

    //====== CONSTRUCTORES ======
    public Puntuazioa() {
    }
    public Puntuazioa(String jokalaria, int puntuak) {
        this.jokalaria = jokalaria;
        this.puntuak = puntuak;
    }

    //====== GETTER Y SETTER ======
    /**
     * Jokalariaren izena itzultzen du.
     *
     * @return jokalariaren izena
     */
    public String getJokalaria() {
        return jokalaria;
    }
    /**
     * Jokalariaren izena ezartzen du.
     *
     * @param jokalaria jokalariaren izen berria
     */
    public void setJokalaria(String jokalaria) {
        this.jokalaria = jokalaria;
    }
    /**
     * Lortutako puntuak itzultzen ditu.
     *
     * @return puntuak
     */
    public int getPuntuak() {
        return puntuak;
    }
    /**
     * Jokalariaren puntuak ezartzen ditu.
     *
     * @param puntuak puntu berriak
     */
    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    //====== TOSTRING ======
    /**
     * Objektuaren informazioa testu formatuan itzultzen du.
     *
     * @return puntuazioaren informazioa
     */
    @Override
    public String toString() {
        return "Jokoa [jokalaria=" + jokalaria + ", puntuak=" + puntuak + "]";
    }    
}
