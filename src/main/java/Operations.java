import javax.swing.text.SimpleAttributeSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.jar.JarEntry;

public class Operations {
    //A Cache before adding to JSON File
    private final ArrayList<Task> taskArrayList = new ArrayList<>();

    JsonHandler jsonHandler = new JsonHandler();


    public Task makeTask(StringBuilder taskString, Status status){
        return new Task(taskString,status);
    }
    // List task's based on different statuses
    public void listDone(){
        for(Task task : taskArrayList){
            if(task.status == Status.DONE) {
                System.out.println(task.toString() + ",");
            }
        }
    }
    public void listTodo(){
        for(Task task : taskArrayList){
            if(task.status == Status.TODO) {
                System.out.println(task.toString() + ",");
            }
        }
    }
    public void listInProgress(){
        for(Task task : taskArrayList){
            if(task.status == Status.IN_PROGRESS) {
                System.out.println(task.toString() + ",");
            }
        }
    }

    // add to arraylist
    public void addToTaskArrayList(Task taskToAdd){
        if (taskToAdd == null) {
            System.err.println("Error: Can't append NULL to taskArrayList!");
        }
        taskArrayList.add(taskToAdd);
        try{
            System.out.println("Task added successfully (ID: " + taskToAdd.getID() + ")");
            jsonHandler.saveToFile(taskArrayList);
        } catch (NullPointerException e){
            System.err.println("Error: .getID() on taskToAdd returned a NULLPOINTEREXCEPTION");
        }
    }

    // update STATUS of the task - DONE,IN-PROGRES,TODO (todo get assigned automatically
    // when TASK is instantiated
    public void updateStatus(int taskID, Status status){
        for(Task task : taskArrayList){
            if(task.getID() == taskID){
                task.setStatus(status);
                System.out.println("Task Status Updated!");
                jsonHandler.saveToFile(taskArrayList);
                return;
            }
        }
        System.err.println("Error: Task with ID " + taskID + " doesn't exist");
    }

    // delete from array list
    public void deleteTaskFromArrayList(int uuid){
        for(Task task : taskArrayList){
            if(task.getID() == uuid) {
                taskArrayList.remove(task);
                System.out.println("Task " + task.getID() + ": Deleted!");
                jsonHandler.saveToFile(taskArrayList);
                return;
            }
        }
        System.err.println("Error: ID doesn't exist!");
    }

    // update a task
    public void updateTaskFromArrayList(int id, StringBuilder updatedDescription){
        for(Task task : taskArrayList){
            if(task.getID() == id) {
                task.description = updatedDescription;
                System.out.println("Task " + task.getID() + ": updated.");
                jsonHandler.saveToFile(taskArrayList);
                return;
            }
        }
        System.err.println("Error: ID doesn't exist!");
    }

    public void printTaskList(){
        for(Task task : taskArrayList){
            System.out.print(task + ", ");
        }
        System.out.println("\n");
    }

    // Nested Class - Only can be accessed via Operations class
    public static class Task{
        private static int counter = 0;
        private int ID ;
        private StringBuilder description;
        private Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // private constructor
       protected Task(StringBuilder taskDescription, Status status){
            this.ID = this.counter+1;
            counter++;
            this.description = taskDescription;
            this.status = status;
            this.createdAt = LocalDateTime.now();
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public int getID() {
            return ID;
        }

        public StringBuilder getDescription() {
            return description;
        }

        public Status getStatus() {
            return status;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "ID=" + ID +
                    ", description=" + description +
                    ", status=" + status +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt+
                    '}';
        }
    }
}
