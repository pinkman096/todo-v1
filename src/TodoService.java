import java.util.Vector;

public class TodoService {
    private Vector tasks = new Vector();
    int idCounter = 1;


    public int addTask(String taskDescription) {
        if (taskDescription == null || taskDescription.length() == 0) {
            return 0;
        }

        if (checkTaskByTitle(taskDescription)) {
            return 1;
        }

        TodoItem newItem = new TodoItem(idCounter, taskDescription);
        tasks.addElement(newItem);
        idCounter++;
        return 2;
    }

    public int deleteTask(String taskId) {
        try {
            int id = Integer.parseInt(taskId);
            if (tasksIsEmpty()) {
                return 1;
            }

            TodoItem item = getTaskById(id);

            if (item == null){
                return 2;
            }


            tasks.removeElement(item);
            return 3;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public Vector getTasks() {
        return new Vector(tasks);
    }

    public int updateTask(String taskId, String newDescription) {

        if (newDescription == null || newDescription.length() == 0) {
            return 0;
        }

        try {
            int id = Integer.parseInt(taskId);

            if (tasksIsEmpty()) {
                return -1;
            }

            TodoItem item = getTaskById(id);

            if (item == null) {
                return 2;
            }

            item.setItemTitle(newDescription);
            return 3;
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public int markAsDone(String taskId) {
        try {
            int id = Integer.parseInt(taskId);
            if (tasksIsEmpty()) {
                return 1;
            }

            TodoItem item = getTaskById(id);

            if (item == null){
                return 2;
            }

            item.setItemStatus(true);
            return 3;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public TodoItem getTaskById(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (taskId == ((TodoItem) tasks.elementAt(i)).getItemId()) {
                return (TodoItem) tasks.elementAt(i);
            }
        }

        return null;
    }

    public boolean checkTaskByTitle(String taskDescription) {
        for (int i = 0; i < tasks.size(); i++) {
            TodoItem item = (TodoItem) tasks.elementAt(i);
            if (taskDescription.equals(item.getItemTitle())) {
                return true;
            }
        }

        return false;
    }

    private boolean tasksIsEmpty() {
        return tasks.size() == 0;
    }
}

