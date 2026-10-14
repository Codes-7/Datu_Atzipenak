package paagbi.model;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Larrialdia {

    //====== ATRIBUTOS ======
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "larritasuna")
    private String larritasuna;
    @XmlElement(name = "koordenatua")
    private Koordenatua koordenatua;

    //====== CONSTRUCTORES ======
        public Larrialdia() {
    }
    public Larrialdia(String id, String izena, String larritasuna, Koordenatua koordenatua) {
        this.id = id;
        this.izena = izena;
        this.larritasuna = larritasuna;
        this.koordenatua = koordenatua;
    }

    //====== GETTER Y SETTER ======
        public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public String getLarritasuna() {
        return larritasuna;
    }
    public void setLarritasuna(String larritasuna) {
        this.larritasuna = larritasuna;
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
        return "Larrialdia [id=" + id + ", izena=" + izena + ", larritasuna=" + larritasuna + ", koordenatua="
                + koordenatua + "]";
    }
}
