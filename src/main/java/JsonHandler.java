import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
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
            System.err.println("Error: filePath Issue within FileWriter \"fr\"");
        }
    }
    public void loadFile(ArrayList<Operations.Task> taskArrayList){
        try(FileReader fr  = new FileReader(filePath)){
            Type listType = new TypeToken<ArrayList<Operations.Task>>(){}.getType();

            ArrayList<Operations.Task> importedList = gson.fromJson(fr,listType);
            if(importedList != null){
                taskArrayList.addAll(importedList);
                System.out.println("Tasks from JSON imported!");
            }
        } catch (IOException e){
            System.err.println("Json File NOT FOUND!");
        }
    }
}
