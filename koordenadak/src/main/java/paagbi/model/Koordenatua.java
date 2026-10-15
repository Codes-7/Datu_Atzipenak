package paagbi.model;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Koordenatu geografikoak adierazten dituen klasea.
 *
 * Latitude eta longitude balioak gordetzen ditu,
 * kokaleku baten posizioa zehazteko.
 *
 * JAXB erabiliz XML fitxategitik kargatzen da.
 *
 * @author Maider Santesteban
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Koordenatua {
    //===== ATRIBUTOS =====
    @XmlElement(name = "latitude")
    private double latitude;
    @XmlElement(name = "longitude")
    private double longitude;

    //===== CONSTRUCTORES =====
    /**
     * JAXB-rentzat beharrezkoa den eraikitzaile hutsa.
     */
    public Koordenatua() {
    }
    /**
     * Koordenatu berri batzuk sortzen ditu.
     *
     * @param latitude latitude balioa
     * @param longitude longitude balioa
     */
    public Koordenatua(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    //===== GETTER Y SETTER =====
    /**
     * Latitude balioa itzultzen du.
     *
     * @return latitude balioa
     */
    public double getLatitude() {
        return latitude;
    }
    /**
     * Latitude balioa ezartzen du.
     *
     * @param latitude latitude berria
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /**
     * Longitude balioa itzultzen du.
     *
     * @return longitude balioa
     */
    public double getLongitude() {
        return longitude;
    }
    /**
     * Longitude balioa ezartzen du.
     *
     * @param longitude longitude berria
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    //===== TOSTRING =====
    /**
     * Objektuaren informazioa testu formatuan itzultzen du.
     *
     * @return koordenatuen informazioa
     */
    @Override
    public String toString() {
        return "Koordenatua [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}