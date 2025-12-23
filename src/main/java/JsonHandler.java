import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JsonHandler {
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeAdaptor())
            .setPrettyPrinting()
            .create();

    String filePath = "task.json";
    public void saveToFile(ArrayList<Operations.Task> taskArrayList){
        try(FileWriter fr = new FileWriter(filePath)){
            gson.toJson(taskArrayList,fr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
