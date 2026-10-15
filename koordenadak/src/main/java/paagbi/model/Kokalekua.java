package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Kokalekua {

    //===== ATRIBUTOS =====
    @XmlAttribute (name = "id")
    private int id;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "koordenatua")
    private Koordenatua koordenatua;

    //====== CONSTRUCTORES ======
    public Kokalekua() {
    }
    public Kokalekua(int id, String izena, Koordenatua koordenatua) {
        this.id = id;
        this.izena = izena;
        this.koordenatua = koordenatua;
    }

    //====== GETTER Y SETTER ======
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public Koordenatua getKoordenatua() {
        return koordenatua;
    }
    public void setKoordenatua(Koordenatua koordenatua) {
        this.koordenatua = koordenatua;
    }

    //====== TOSTRING ======
    @Override
    public String toString() {
        return "Kokalekua [id=" + id + ", izena=" + izena + ", koordenatua=" + koordenatua + "]";
    }

}

