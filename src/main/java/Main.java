import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // returns connected string from a String[] for task description
    public static StringBuilder getString(String[] strings){
        StringBuilder result = new StringBuilder();
        for(String string : strings){
            result.append(string).append(" ");
        }
        return result;
    }

    public static boolean isInteger(String str){
        try{
            int taskID = Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();


        while(true){
            String userInput = sc.nextLine();

            if(userInput.equalsIgnoreCase("exit"))break; // Exit clause for white loop
            String[] userInputARRAY= userInput.split(" "); //raw string arr
            // this gets us the task string description
            StringBuilder taskString;
            int taskInt = 0;
            if(isInteger(userInputARRAY[1])){
                taskInt = Integer.parseInt(userInputARRAY[1]);
                taskString = getString(Arrays.copyOfRange(userInputARRAY,2, userInputARRAY.length));
            }else{
                taskString = getString(Arrays.copyOfRange(userInputARRAY,1,userInputARRAY.length));
            }
            switch(userInputARRAY[0].toLowerCase()){
                case "add":
                    //makes a task and then adds to the taskArray list
                    op.addToTaskArrayList(op.makeTask(taskString,Status.TODO));
                    op.printTaskList();
                    break;

                case "delete":
                    op.deleteTaskFromArrayList(taskInt);
                    op.printTaskList();
                    break;

                case "update":
                    System.out.println("update");
                    break;
            }

        }


    }
}
