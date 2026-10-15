package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Puntuazioa {

    @XmlElement(name = "izena")
    private String jokalaria;
    @XmlElement(name = "izena")
    private int puntuak;

    //====== CONSTRUCTORES ======
    public Puntuazioa() {
    }
    public Puntuazioa(String jokalaria, int puntuak) {
        this.jokalaria = jokalaria;
        this.puntuak = puntuak;
    }

    //====== GETTER Y SETTER ======
    public String getJokalaria() {
        return jokalaria;
    }
    public void setJokalaria(String jokalaria) {
        this.jokalaria = jokalaria;
    }
    public int getPuntuak() {
        return puntuak;
    }
    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    //====== TOSTRING ======
    @Override
    public String toString() {
        return "Jokoa [jokalaria=" + jokalaria + ", puntuak=" + puntuak + "]";
    }
    
}
