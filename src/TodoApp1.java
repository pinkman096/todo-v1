import java.io.IOException;
import java.util.Vector;

public class TodoApp1 {
    public static void main(String[] args) throws IOException {
        TodoService todoService = new TodoService();

        while (true) {
            printMenu();
            String userInput = readLineFromConsole();

            if (userInput.equals("1")) {
                System.out.println("enter a description of a task");
                String description = readLineFromConsole();
                int result = todoService.addTask(description);

                if (result == 0) {
                    System.out.println("task description cannot be empty");
                } else if (result == 1) {
                    System.out.println("task with such description already exists");
                } else if (result == 2) {
                    System.out.println("task successfully added");
                }
            } else if (userInput.equals("2")) {
                System.out.println("enter id of the task to update");
                String taskId = readLineFromConsole();
                System.out.println("enter new description");
                String newDescription = readLineFromConsole();

                int result = todoService.updateTask(taskId, newDescription);

                if (result == -1) {
                    System.out.println("no any tasks");
                } else if (result == 0) {
                    System.out.println("task description cannot be empty");
                } else if (result == 1) {
                    System.out.println("wrong format for id");
                } else if (result == 2) {
                    System.out.println("task with id " + taskId + " not exists");
                } else if (result == 3) {
                    System.out.println("task successfully updated");
                }
            } else if (userInput.equals("3")) {
                System.out.println("enter id of the task to mark as done");
                String taskId = readLineFromConsole();

                int result = todoService.markAsDone(taskId);

                if (result == 0) {
                    System.out.println("wrong format for id");
                } else if (result == 1) {
                    System.out.println("no any tasks");
                } else if (result == 2) {
                    System.out.println("task with id " + taskId + " not exists");
                } else if (result == 3) {
                    System.out.println("task successfully marked as done");
                }
            } else if (userInput.equals("4")) {
                System.out.println("enter id of the task to delete");
                String taskId = readLineFromConsole();

                int result = todoService.deleteTask(taskId);

                if (result == 0) {
                    System.out.println("wrong format for id");
                } else if (result == 1) {
                    System.out.println("no any tasks");
                } else if (result == 2) {
                    System.out.println("task with id " + taskId + " not exists");
                } else if (result == 3) {
                    System.out.println("task successfully deleted");
                }

            } else if (userInput.equals("5")) {
                Vector tasks = todoService.getTasks();
                printTasks(tasks);
            } else if (userInput.equals("6")) {
                System.out.println("exiting...");
                break;
            } else {
                System.out.println("wrong command, try again");
            }
        }
    }

    private static void printMenu() {
        System.out.println("---TodoApp v1---");
        System.out.println("1 - add task");
        System.out.println("2 - update task");
        System.out.println("3 - mark task as done");
        System.out.println("4 - delete task");
        System.out.println("5 - show tasks");
        System.out.println("6 - exit");
        System.out.println("Enter command");
    }

    private static void printTasks(Vector tasks) {
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(tasks.elementAt(i));
            }
        } else {
            System.out.println("no any tasks");
        }
    }

    private static String readLineFromConsole() throws IOException {
        StringBuffer s = new StringBuffer();

        while (true) {
            int userInput = System.in.read();
            if (userInput == 10) {
                break;
            }

            s.append((char) userInput);

        }

        return s.toString();
    }
}
