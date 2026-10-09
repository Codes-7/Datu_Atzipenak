package paagbi;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class JsonZuhaitzaSortuBi {
    public static void main(String[] args) {
        JsonObject model = Json.createObjectBuilder()
        .add("menu", Json.createObjectBuilder()
            .add("id", "file")
            .add("value", "File")
            //Popup es otro objeto así que lo añadimos así
            .add("popup", Json.createObjectBuilder()
                //Menuitem sí que es un array
                .add("menuitem", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder()
                        .add("value", "New")
                        .add("onclick", "CreateNewDoc()"))

                    .add(Json.createObjectBuilder()
                        .add("value", "Open")
                        .add("onclick", "OpenDoc()"))

                    .add(Json.createObjectBuilder()
                        .add("value", "Close")
                        .add("onclick", "CloseDoc()"))
                )
            )                       
        )
        .build();
        System.out.println(model);
    }
}
