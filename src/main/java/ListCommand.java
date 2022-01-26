public class ListCommand extends Command {
    @Override
    public void execute(TaskArrayList taskArrayList, Ui ui, Storage storage) throws AeromonException {
        ui.print(taskArrayList.getTaskList() + taskArrayList.getTasksStatus());
    }
}
