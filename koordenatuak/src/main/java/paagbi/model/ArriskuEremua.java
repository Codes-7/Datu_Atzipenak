package paagbi.model;
import java.util.List;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArriskuEremua {

    //====== ATRIBUTOS ======
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "mota")
    private String mota;
    @XmlElementWrapper(name = "koordenatuak")
    @XmlElement(name = "koordenatua")
    private List<Koordenatua> koordenatuak;

    //====== CONSTRUCTORES ======
    public ArriskuEremua() {
    }
    public ArriskuEremua(String id, String izena, String mota,  List<Koordenatua> koordenatuak) {
        this.id = id;
        this.izena = izena;
        this.mota = mota;
        this.koordenatuak = koordenatuak;
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
    public List<Koordenatua> getKoordenatuak() {
        return koordenatuak;
    }
    public void setKoordenatuak(List<Koordenatua> koordenatuak) {
        this.koordenatuak = koordenatuak;
    }
    
    //====== TOSTRING ======
    @Override
    public String toString() {
        return "ArriskuEremua [id=" + id + ", izena=" + izena + ", mota=" + mota + ", koordenatuak=" + koordenatuak
                + "]";
    }

}
