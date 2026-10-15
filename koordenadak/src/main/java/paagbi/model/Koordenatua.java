package paagbi.model;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Koordenatua {

    //===== ATRIBUTOS =====
    @XmlElement(name = "latitude")
    private double latitude;
    @XmlElement(name = "longitude")
    private double longitude;

    //===== CONSTRUCTORES =====
    public Koordenatua() {
    }

    public Koordenatua(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    //===== GETTER Y SETTER =====
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //===== TOSTRING =====
    @Override
    public String toString() {
        return "Koordenatua [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
    
    
}