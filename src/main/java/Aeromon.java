import java.util.ArrayList;

public class Aeromon {

    private TaskArrayList taskList;
    private Ui ui;
    private Storage storage;

    public Aeromon(String fileLocation) {
        ui = new Ui();
        storage = new Storage(fileLocation);

        try {
            taskList = new TaskArrayList(storage.getFile());
        } catch (AeromonException e) {
            ui.print(e.getMessage());
            taskList = new TaskArrayList(new ArrayList<>());
        }
    }

    public void start() {
        ui.greet();
        boolean isBye = false;
        while (!isBye) {
            try {
                String fullCommand = ui.readCommand();
                Command command = CommandManager.read(fullCommand);
                command.execute(taskList, ui, storage);
                isBye = command.isExit();
            } catch (AeromonException e) {
                ui.print(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Aeromon aeromon = new Aeromon("data/localTasks.txt");
        aeromon.start();
    }
}
