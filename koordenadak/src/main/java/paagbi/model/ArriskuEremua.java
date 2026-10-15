package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArriskuEremua {

    //====== ATRIBUTOS ======
    @XmlElement(name = "izena")
    private String izena;
    @XmlElement(name = "latMin")
    private double latMin;
    @XmlElement(name = "latMax")
    private double latMax;
     @XmlElement(name = "lonMin")
    private double lonMin;
    @XmlElement(name = "lonMax")
    private double lonMax;


    //====== CONSTRUCTORES ======
    public ArriskuEremua() {
    }


    public ArriskuEremua(String izena, double latMin, double latMax, double lonMin, double lonMax) {
        this.izena = izena;
        this.latMin = latMin;
        this.latMax = latMax;
        this.lonMin = lonMin;
        this.lonMax = lonMax;
    }

    //====== GETTER Y SETTER ======
    public String getIzena() {
        return izena;
    }
    public void setIzena(String izena) {
        this.izena = izena;
    }
    public double getLatMin() {
        return latMin;
    }
    public void setLatMin(double latMin) {
        this.latMin = latMin;
    }
    public double getLatMax() {
        return latMax;
    }
    public void setLatMax(double latMax) {
        this.latMax = latMax;
    }
    public double getLonMin() {
        return lonMin;
    }
    public void setLonMin(double lonMin) {
        this.lonMin = lonMin;
    }
    public double getLonMax() {
        return lonMax;
    }
    public void setLonMax(double lonMax) {
        this.lonMax = lonMax;
    }

    //====== TOSTRING ======
    @Override
    public String toString() {
        return "ArriskuEremua [izena=" + izena + ", latMin=" + latMin + ", latMax=" + latMax + ", lonMin=" + lonMin
                + ", lonMax=" + lonMax + "]";
    }


}
