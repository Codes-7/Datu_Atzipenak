package paagbi.model;

import java.util.List;
//Import para el JAXB
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

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
    public Jokoa() {
    }
    public Jokoa(List<Kokalekua> kokalekuak, List<ArriskuEremua> arriskuEremuak) {
        this.kokalekuak = kokalekuak;
        this.arriskuEremuak = arriskuEremuak;
    }

    //====== GETTER Y SETTER ======
    public List<Kokalekua> getKokalekuak() {
        return kokalekuak;
    }
    public void setKokalekuak(List<Kokalekua> kokalekuak) {
        this.kokalekuak = kokalekuak;
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
        return "Jokoa [kokalekuak=" + kokalekuak + ", arriskuEremuak=" + arriskuEremuak + "]";
    }
    
}
