import java.time.LocalDateTime;
import java.util.ArrayList;

public class Operations {
    //A Cache before adding to JSON File
    private ArrayList<Task> taskArrayList = new ArrayList<>();


    public Task makeTask(StringBuilder taskString, Status status){
        return new Task(taskString,status);
    }


    // add to arraylist
    public void addToTaskArrayList(Task taskToAdd){
        if (taskToAdd == null) {
            System.err.println("Error: Can't append NULL to taskArrayList!");
            return;
        }
        taskArrayList.add(taskToAdd);
    }


    // delete from array list
    public void deleteTaskFromArrayList(int uuid){
        for(Task task : taskArrayList){
            if(task.getID() == uuid){
                taskArrayList.remove(task);
                return;
            }else{
                System.err.println("Error: ID doesn't exist!");
            }
        }
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
        private Task(StringBuilder taskDescription, Status status){
            this.ID = this.counter+1;
            counter++;
            this.description = taskDescription;
            this.status = status;
            this.createdAt = LocalDateTime.now();
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
