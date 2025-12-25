import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // returns connected string from a String[] for task description
    public static StringBuilder getString(String[] strings) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (String string : strings) {
            result.append(string);
            counter++;
            if (counter < strings.length) {
                result.append(" ");
            }
        }
        return result;
    }

    // helper function
    public static boolean isInteger(String str) {
        try {
            int taskID = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();

        switch(args[0]){
            case "add":
                //makes a task and then adds to the taskArray list
                op.addToTaskArrayList(op.makeTask(args[1], Status.TODO));

                break;

            case "delete":
                op.deleteTaskFromArrayList(taskInt);

                break;

            case "update":
                op.updateTaskFromArrayList(taskInt, taskString);
                break;

            case "mark-done":
                op.updateStatus(taskInt, Status.DONE);
                break;

            case "mark-in-progress":
                op.updateStatus(taskInt, Status.IN_PROGRESS);
                break;

            case "list":
                if (userInputARRAY[1].equalsIgnoreCase("done")) {
                    op.listDone();
                } else if (userInputARRAY[1].equalsIgnoreCase("todo")) {
                    op.listTodo();
                } else if (userInputARRAY[1].equalsIgnoreCase("in-progress")) {
                    op.listInProgress();
                } else {
                    System.err.println("Error: Enter a valid status to list! (done,todo,in-progress)");
                }
                break;

        }
        /*
        while (true) {
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("exit")) break; // Exit clause for white loop
            try {
                String[] userInputARRAY = userInput.split(" ");//raw string arr

                // this gets us the task string description
                StringBuilder taskString;
                int taskInt = 0;
                if (isInteger(userInputARRAY[1])) {
                    taskInt = Integer.parseInt(userInputARRAY[1]);
                    taskString = getString(Arrays.copyOfRange(userInputARRAY, 2, userInputARRAY.length));
                } else {
                    taskString = getString(Arrays.copyOfRange(userInputARRAY, 1, userInputARRAY.length));
                }

                switch (userInputARRAY[0].toLowerCase()) {
                    case "add":
                        //makes a task and then adds to the taskArray list
                        op.addToTaskArrayList(op.makeTask(taskString, Status.TODO));

                        break;

                    case "delete":
                        op.deleteTaskFromArrayList(taskInt);

                        break;

                    case "update":
                        op.updateTaskFromArrayList(taskInt, taskString);
                        break;

                    case "mark-done":
                        op.updateStatus(taskInt, Status.DONE);
                        break;

                    case "mark-in-progress":
                        op.updateStatus(taskInt, Status.IN_PROGRESS);
                        break;

                    case "list":
                        if (userInputARRAY[1].equalsIgnoreCase("done")) {
                            op.listDone();
                        } else if (userInputARRAY[1].equalsIgnoreCase("todo")) {
                            op.listTodo();
                        } else if (userInputARRAY[1].equalsIgnoreCase("in-progress")) {
                            op.listInProgress();
                        } else {
                            System.err.println("Error: Enter a valid status to list! (done,todo,in-progress)");
                        }
                        break;
                }

            } catch (IndexOutOfBoundsException e) {
                // Since the user entered nothing it
                // Out of bound error occurs when we try to access userInputARRAY
                System.err.println("Error: Enter Valid Value");
            }

        }
        */
    }
}
