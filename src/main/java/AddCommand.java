import java.time.LocalDate;

public class AddCommand extends Command {
    private TaskType taskType;
    private String[] info;

    public enum TaskType { TODO, DEADLINE, EVENT };

    public AddCommand(TaskType taskType, String[] info) {
        this.taskType = taskType;
        this.info = info;
    }

    @Override
    public void execute(TaskArrayList taskArrayList, Ui ui, Storage storage) {
        System.out.println("Nicely! I've added for you:");

        switch(taskType) {
            case TODO: {
                ToDo task = new ToDo(info[0]);
                taskArrayList.add(task);
                ui.print(task.toString());
                ui.print(taskArrayList.getTasksStatus());
                break;
            }
            case DEADLINE: {
                Deadline task = new Deadline(info[0].trim(), LocalDate.parse(info[1]));
                taskArrayList.add(task);
                ui.print(task.toString());
                ui.print(taskArrayList.getTasksStatus());
                break;
            }
            case EVENT: {
                Event task = new Event(info[0].trim(), LocalDate.parse(info[1]));
                taskArrayList.add(task);
                ui.print(task.toString());
                ui.print(taskArrayList.getTasksStatus());
                break;
            }
        }
        storage.saveFile(taskArrayList.getTasks());
    }
}
