package paagbi.repository;
import java.io.InputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import paagbi.model.Misioak;

public class XmlMisioaRepository {

    public Misioak kargatuMisioak(){
        try{
            //JAXB gure modeloarekin lan egiteko prestatzen dugu.
            JAXBContext context = JAXBContext.newInstance(Misioak.class);
            //XML-tik Java objektuak sortzeko Unmarshaller-a prestatzen dugu.
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //misioak.xml fitxategia irakurtzen dugu.
            InputStream file = getClass().getClassLoader().getResourceAsStream("xml/misioak.xml");
            //Fitxategia existitzen dela egiaztatzen dugu
            if (file == null) {
                throw new IllegalArgumentException("Ezin da misioak.xml fitxategia aurkitu");
            }
            //XML-a Java objektu bihurtzen dugu
            Misioak misioak = (Misioak) unmarshaller.unmarshal(file);

            return misioak;
        } catch (JAXBException e){
            System.err.println(e);
            return null;
        }
          
    }
}
