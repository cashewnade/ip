public class EditCommand extends Command {

    private EditType editType;
    private int taskNum;

    public enum EditType { MARK, UNMARK, DELETE}

    public EditCommand(EditType editType, int taskNum) {
        this.editType = editType;
        this.taskNum = taskNum;
    }

    @Override
    public void execute(TaskArrayList taskList, Ui ui, Storage storage) throws AeromonException {
        if (taskNum < 1 || taskNum > taskList.getSize()) {
            throw new AeromonException("Nani is that task number, sir?\n");
        } else {
            switch (editType) {
                case MARK: {
                    int index = taskNum - 1;
                    Task temp = taskList.get(index);
                    temp.markAsDone();
                    storage.saveFile(taskList.getTasks());
                    break;
                }
                case UNMARK: {
                    int index = taskNum - 1;
                    Task temp = taskList.get(index);
                    temp.markAsNotDone();
                    storage.saveFile(taskList.getTasks());
                    break;
                }
                case DELETE: {
                    int index = taskNum - 1;
                    taskList.remove(index);
                    storage.saveFile(taskList.getTasks());
                    break;
                }
            }
        }
    }


}