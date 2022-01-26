public abstract class Command {
    public abstract void execute(TaskArrayList taskArrayList, Ui ui, Storage storage) throws AeromonException;

    public boolean isExit() {
        return this instanceof ByeCommand;
    }
}
