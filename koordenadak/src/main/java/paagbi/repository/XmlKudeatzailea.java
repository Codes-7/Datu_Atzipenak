package paagbi.repository;

import java.io.InputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import paagbi.model.Jokoa;

public class XmlKudeatzailea {

    /**
     * XML fitxategitik jokoaren datuak kargatzen ditu.
     *
     * @return Jokoa objektua
     */
    public Jokoa kargatuJokoa() {
        try {
            //JAXB gure modeloarekin lan egiteko prestatzen dugu.
            JAXBContext context = JAXBContext.newInstance(Jokoa.class);
            //XML-tik Java objektuak sortzeko Unmarshaller-a prestatzen dugu.
            Unmarshaller unmarshaller = context.createUnmarshaller();
            //jokoa.xml fitxategia irakurtzen dugu.
            InputStream file = getClass().getClassLoader().getResourceAsStream("xml/jokoa.xml");
            // Existitzen dela egiaztatzen dugu
            if (file == null) {
                throw new IllegalArgumentException("Ezin da jokoa.xml fitxategia aurkitu");
            }
            Jokoa jokoa = (Jokoa) unmarshaller.unmarshal(file);
            return jokoa;

        } catch (JAXBException e) {
            System.out.println("Errorea XML irakurtzean");
            e.printStackTrace();
            return null;
        }
    }
}
