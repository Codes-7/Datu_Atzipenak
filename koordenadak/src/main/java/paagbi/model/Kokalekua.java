package paagbi.model;

//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Jokoan erabiltzen den kokaleku bat adierazten du.
 *
 * Kokaleku bakoitzak identifikatzaile bat, izen bat eta
 * koordenatu geografiko batzuk ditu.
 *
 * JAXB erabiliz XML fitxategitik kargatzen da.
 *
 * @author Maider Santesteban
 */
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
    /**
     * JAXB-rentzat beharrezkoa den eraikitzaile hutsa.
     */
    public Kokalekua() {
    }

    /**
     * Kokaleku berri bat sortzen du.
     * @param id kokalekuaren identifikatzailea
     * @param izena kokalekuaren izena
     * @param koordenatua kokalekuaren koordenatuak
     */
    public Kokalekua(int id, String izena, Koordenatua koordenatua) {
        this.id = id;
        this.izena = izena;
        this.koordenatua = koordenatua;
    }

    //====== GETTER Y SETTER ======
    /**
     * Kokalekuaren identifikatzailea itzultzen du.
     *
     * @return kokalekuaren identifikatzailea
     */
    public int getId() {
        return id;
    }
    /**
     * Kokalekuaren identifikatzailea ezartzen du.
     *
     * @param id identifikatzaile berria
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Kokalekuaren izena itzultzen du.
     *
     * @return kokalekuaren izena
     */
    public String getIzena() {
        return izena;
    }
    /**
     * Kokalekuaren izena ezartzen du.
     *
     * @param izena kokalekuaren izen berria
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }
    /**
     * Kokalekuaren koordenatuak itzultzen ditu.
     *
     * @return kokalekuaren koordenatuak
     */
    public Koordenatua getKoordenatua() {
        return koordenatua;
    }
    /**
     * Kokalekuaren koordenatuak ezartzen ditu.
     *
     * @param koordenatua koordenatu berriak
     */
    public void setKoordenatua(Koordenatua koordenatua) {
        this.koordenatua = koordenatua;
    }

    //====== TOSTRING ======
    /**
     * Objektuaren informazioa testu formatuan itzultzen du.
     *
     * @return kokalekuaren informazioa
     */
    @Override
    public String toString() {
        return "Kokalekua [id=" + id + ", izena=" + izena + ", koordenatua=" + koordenatua + "]";
    }

}

