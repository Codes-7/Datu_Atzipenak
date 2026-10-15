package paagbi.model;

import java.util.List;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Jokoaren datu guztiak biltzen dituen klase nagusia.
 *
 * Bertan kokalekuak eta arrisku eremuak gordetzen dira. XML fitxategiaren erro elementua da.
 *
 * JAXB erabiliz XML fitxategitik mapatzen da.
 *
 * @author Maider Santesteban
 */
@XmlRootElement(name = "jokoa")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jokoa {

    //===== ATRIBUTOS =====
    @XmlElementWrapper(name = "kokalekuak") 
    @XmlElement(name = "kokalekua")
    private List<Kokalekua> kokalekuak;
    @XmlElementWrapper(name = "arriskuEremuak") 
    @XmlElement(name = "arriskuEremua")
    private List<ArriskuEremua> arriskuEremuak;

    //====== CONSTRUCTORES ======
    /**
     * JAXB-rentzat beharrezkoa den eraikitzaile hutsa.
     */
    public Jokoa() {
    }

    /**
     * Joko berri bat sortzen du.
     *
     * @param kokalekuak jokoaren kokalekuak
     * @param arriskuEremuak jokoaren arrisku eremuak
     */
    public Jokoa(List<Kokalekua> kokalekuak, List<ArriskuEremua> arriskuEremuak) {
        this.kokalekuak = kokalekuak;
        this.arriskuEremuak = arriskuEremuak;
    }

    //====== GETTER Y SETTER ======
    /**
     * Jokoaren kokalekuak itzultzen ditu.
     *
     * @return kokalekuen zerrenda
     */
    public List<Kokalekua> getKokalekuak() {
        return kokalekuak;
    }
    /**
     * Jokoaren kokalekuak ezartzen ditu.
     *
     * @param kokalekuak kokalekuen zerrenda berria
     */
    public void setKokalekuak(List<Kokalekua> kokalekuak) {
        this.kokalekuak = kokalekuak;
    }
    /**
     * Jokoaren arrisku eremuak itzultzen ditu.
     *
     * @return arrisku eremuen zerrenda
     */
    public List<ArriskuEremua> getArriskuEremuak() {
        return arriskuEremuak;
    }
    /**
     * Jokoaren arrisku eremuak ezartzen ditu.
     *
     * @param arriskuEremuak arrisku eremuen zerrenda berria
     */
    public void setArriskuEremuak(List<ArriskuEremua> arriskuEremuak) {
        this.arriskuEremuak = arriskuEremuak;
    }

    //====== TOSTRING ======
    /**
     * Objektuaren informazioa testu formatuan itzultzen du.
     *
     * @return jokoaren informazioa
     */
    @Override
    public String toString() {
        return "Jokoa [kokalekuak=" + kokalekuak + ", arriskuEremuak=" + arriskuEremuak + "]";
    }   
}
