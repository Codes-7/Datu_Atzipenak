package paagbi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import jakarta.json.Json;
import jakarta.json.JsonReader;
import jakarta.json.JsonStructure;

public class JsonFitxategiaIrakurri {
    public static void main(String[] args) throws FileNotFoundException{
        JsonReader reader = Json.createReader(new FileReader("jsondata.txt"));
        JsonStructure jsonst = reader.read();
        System.out.println(jsonst.getValueType()); //object edo array inprimatu
        System.out.println(jsonst);
    }
}
