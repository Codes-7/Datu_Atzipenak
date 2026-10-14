package paagbi.model;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErreskateTaldea {

    //====== ATRIBUTOS ======
     @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "mota")
    private String mota;
    @XmlElement(name = "koordenatua")
    private Koordenatua koordenatua;

    //====== CONSTRUCTORES ======
    public ErreskateTaldea() {
    }
    public ErreskateTaldea(String id, String izena, String mota, Koordenatua koordenatua) {
        this.id = id;
        this.izena = izena;
        this.mota = mota;
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
    public String getMota() {
        return mota;
    }
    public void setMota(String mota) {
        this.mota = mota;
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
        return "ErreskateTaldea [id=" + id + ", izena=" + izena + ", mota=" + mota + ", koordenatua=" + koordenatua
                + "]";
    }

    
}
