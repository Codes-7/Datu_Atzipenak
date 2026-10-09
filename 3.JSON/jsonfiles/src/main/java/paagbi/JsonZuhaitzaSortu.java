package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class JsonZuhaitzaSortu {
    public static void main(String[] args) {
        JsonObject model = Json.createObjectBuilder()
            //Añades todos los valores del Json
            .add("firstName", "Duke")
            .add("lastName", "Java")
            .add("age", 18)
            .add("streetAddress", "100 Internet Dr")
            .add("city", "JavaTown")
            .add("state", "JA")
            .add("postalCode", "12345")
            //Aquí vas a crear Json anidados, por eso metes otro create (en este caso array, porque metes dos objetos dentro)
            .add("phoneNumbers", Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("type", "mobile")
                    .add("number", "111-111-1111"))
                .add(Json.createObjectBuilder()
                    .add("type", "home")
                    .add("number", "222-222-2222")))
            .build(); //IMPORTANTE NO OLVIDAR.Con esto ya construímos el objeto de Json con todos los add.
        System.out.println(model);
        
    }

}
