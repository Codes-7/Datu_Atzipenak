package paagbi.model;
import java.util.List;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class Misioa {

    //====== ATRIBUTOS ======
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "izena")
    private String izena;
    @XmlElementWrapper(name = "erreskateTaldeak")
    @XmlElement(name = "erreskateTaldea")
    private List<ErreskateTaldea> erreskateTaldeak;
    @XmlElementWrapper(name = "larrialdiak")
    @XmlElement(name = "larrialdia")
    private List<Larrialdia> larrialdiak;
    @XmlElementWrapper(name = "arriskuEremuak")
    @XmlElement(name = "arriskuEremua")
    private List<ArriskuEremua> arriskuEremuak;

    //====== CONSTRUCTORES ======
    public Misioa() {
    }
    public Misioa(String id, String izena, List<ErreskateTaldea> erreskateTaldeak, List<Larrialdia> larrialdiak,
            List<ArriskuEremua> arriskuEremuak) {
        this.id = id;
        this.izena = izena;
        this.erreskateTaldeak = erreskateTaldeak;
        this.larrialdiak = larrialdiak;
        this.arriskuEremuak = arriskuEremuak;
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
    public List<ErreskateTaldea> getErreskateTaldeak() {
        return erreskateTaldeak;
    }
    public void setErreskateTaldeak(List<ErreskateTaldea> erreskateTaldeak) {
        this.erreskateTaldeak = erreskateTaldeak;
    }
    public List<Larrialdia> getLarrialdiak() {
        return larrialdiak;
    }
    public void setLarrialdiak(List<Larrialdia> larrialdiak) {
        this.larrialdiak = larrialdiak;
    }
    public List<ArriskuEremua> getArriskuEremuak() {
        return arriskuEremuak;
    }
    public void setArriskuEremuak(List<ArriskuEremua> arriskuEremuak) {
        this.arriskuEremuak = arriskuEremuak;
    }

    //====== TOSTRING ======
    @Override
    public String toString() {
        return "Misioa [id=" + id + ", izena=" + izena + ", erreskateTaldeak=" + erreskateTaldeak + ", larrialdiak="
                + larrialdiak + ", arriskuEremuak=" + arriskuEremuak + "]";
    }
  
}
