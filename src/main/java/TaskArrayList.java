import java.util.ArrayList;

public class TaskArrayList {
    private ArrayList<Task> tasks;

    public TaskArrayList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public Task get(int i) {
        return tasks.get(i);
    }

    public Task remove(int i) {
        return tasks.remove(i);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public int getSize() {
        return tasks.size();
    }

    public String getTaskList() {
        String list = "Konnichiwassup! Look at how much work you have to do!\n";
        for (int i = 0; i < tasks.size(); i++) {
            list += (i + 1) + ". " + tasks.get(i).toString() + "\n";
        }
        return list;
    }

    public String getTasksStatus() {
        if (tasks.size() == 0) {
            return "Nicely! No more tasks on the list! Good job! :)";
        } else {
            return String.format("You currently have %d tasks on the list >.< Jiayous", tasks.size());
        }
    }
}
