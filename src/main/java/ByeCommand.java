public class ByeCommand extends Command {
    @Override
    public void execute(TaskArrayList taskArrayList, Ui ui, Storage storage) throws AeromonException {
        ui.print("Buai Buai! Ciao for now!");
    }
}
