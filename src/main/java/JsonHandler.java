import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class JsonHandler {
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeAdaptor())
            .setPrettyPrinting()
            .create();

    public void saveToFile(ArrayList<Operations.Task> taskArrayList){
        StringBuilder jsonString = new StringBuilder();
        for(Operations.Task task : taskArrayList){
            jsonString.append(gson.toJson(task));
        }
        System.out.println(jsonString + "\n");
    }
}
