package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Arrisku eremu geografiko bat adierazten duen klasea.
 *
 * Eremua latitude eta longitude muga batzuen bidez
 * definitzen da, eta kokaleku bat barruan dagoen
 * egiaztatzeko erabiltzen da.
 *
 * JAXB erabiliz XML fitxategitik kargatzen da.
 *
 * @author Maider Santesteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ArriskuEremua {
    //====== ATRIBUTOS ======
    @XmlAttribute (name = "id")
    private int id;
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
    /**
     * JAXB-rentzat beharrezkoa den eraikitzaile hutsa.
     */
    public ArriskuEremua() {
    }
    /**
     * Arrisku eremu berri bat sortzen du.
     *
     * @param izena eremuaren izena
     * @param latMin latitude minimoa
     * @param latMax latitude maximoa
     * @param lonMin longitude minimoa
     * @param lonMax longitude maximoa
     */
    public ArriskuEremua(int id, String izena, double latMin, double latMax, double lonMin, double lonMax) {
        this.id = id;
        this.izena = izena;
        this.latMin = latMin;
        this.latMax = latMax;
        this.lonMin = lonMin;
        this.lonMax = lonMax;
    }

    //====== GETTER Y SETTER ======
    /**
     * Arrisku eremuaren identifikatzailea itzultzen du.
     *
     * @return arrisku eremuaren identifikatzailea
     */
    public int getId() {
        return id;
    }
    /**
     * Arrisku eremuaren identifikatzailea ezartzen du.
     *
     * @param id identifikatzaile berria
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Arrisku eremuaren izena itzultzen du.
     *
     * @return arrisku eremuaren izena
     */
    public String getIzena() {
        return izena;
    }
    /**
     * Arrisku eremuaren izena ezartzen du.
     *
     * @param izena arrisku eremuaren izen berria
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }
    /**
     * Latitude minimoa itzultzen du.
     *
     * @return latitude minimoa
     */
    public double getLatMin() {
        return latMin;
    }
    /**
     * Latitude minimoa ezartzen du.
     *
     * @param latMin latitude minimo berria
     */
    public void setLatMin(double latMin) {
        this.latMin = latMin;
    }
    /**
     * Latitude maximoa itzultzen du.
     *
     * @return latitude maximoa
     */
    public double getLatMax() {
        return latMax;
    }
    /**
     * Latitude maximoa ezartzen du.
     *
     * @param latMax latitude maximo berria
     */
    public void setLatMax(double latMax) {
        this.latMax = latMax;
    }
    /**
     * Longitude minimoa itzultzen du.
     *
     * @return longitude minimoa
     */
    public double getLonMin() {
        return lonMin;
    }
    /**
     * Longitude minimoa ezartzen du.
     *
     * @param lonMin longitude minimo berria
     */
    public void setLonMin(double lonMin) {
        this.lonMin = lonMin;
    }
    /**
     * Longitude maximoa itzultzen du.
     *
     * @return longitude maximoa
     */
    public double getLonMax() {
        return lonMax;
    }
    /**
     * Longitude maximoa ezartzen du.
     *
     * @param lonMax longitude maximo berria
     */
    public void setLonMax(double lonMax) {
        this.lonMax = lonMax;
    }

    //====== TOSTRING ======
    /**
     * Objektuaren informazioa testu formatuan itzultzen du.
     *
     * @return arrisku eremuaren informazioa
     */
    @Override
    public String toString() {
        return "ArriskuEremua [id=" + id + ", izena=" + izena + ", latMin=" + latMin + ", latMax=" + latMax
                + ", lonMin=" + lonMin + ", lonMax=" + lonMax + "]";
    }
}
