package paagbi.model;
import java.util.List;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "misioak")
@XmlAccessorType(XmlAccessType.FIELD)
public class Misioak {

    //===== ATRIBUTOS =====
     @XmlElement(name = "misioa")
    private List<Misioa> misioak;

    //====== CONSTRUCTORES ======
    public Misioak() {
    }

    public Misioak(List<Misioa> misioak) {
        this.misioak = misioak;
    }

    //====== GETTER Y SETTER ======
    public List<Misioa> getMisioak() {
        return misioak;
    }

    public void setMisioak(List<Misioa> misioak) {
        this.misioak = misioak;
    }

    //====== TOSTRING ======
    @Override
    public String toString() {
        return "Misioak [misioak=" + misioak + "]";
    }
    
}
