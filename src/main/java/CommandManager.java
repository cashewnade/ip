import java.text.ParseException;
import java.time.LocalDate;

public class CommandManager {
    public static Command read(String fullCommand) throws AeromonException {
        String[] arr = fullCommand.split(" ", 2);
        String command = arr[0];

        switch (command) {
            case "bye":
                return new ByeCommand();

            case "list":
                return new ListCommand();

            case "mark": {
                int taskNum = getTaskNum(arr[1]);
                return new EditCommand(EditCommand.EditType.MARK, taskNum);
            }

            case "unmark": {
                int taskNum = getTaskNum(arr[1]);
                return new EditCommand(EditCommand.EditType.UNMARK, taskNum);
            }

            case "delete": {
                int taskNum = getTaskNum(arr[1]);
                return new EditCommand(EditCommand.EditType.DELETE, taskNum);
            }

            case "todo": {
                return new AddCommand(AddCommand.TaskType.TODO, new String[] { checkDescription("Todo",arr[1]) });
            }

            case "deadline": {
                String description = checkDescription("Deadline", arr[1]);
                String[] info = description.split(" /by ");
                return new AddCommand(AddCommand.TaskType.DEADLINE, info);
            }

            case "event": {
                String description = checkDescription("Event", arr[1]);
                String[] info = description.split(" /at ");
                return new AddCommand(AddCommand.TaskType.EVENT, info);
            }

            default:
                throw new AeromonException("Nani? Me no understand what you say .-.");
        }
    }

    public static String checkDescription(String taskType, String description) throws AeromonException {
        String s = description.trim();
        if (s.isEmpty()) {
            throw new AeromonException(String.format("What do you want to do? The description of %s cannot be empty!\n", taskType));
        } else if (taskType.equals("Deadline")) {
            try {
                String[] arr = description.split(" /by ");
                String by = arr[1].trim();
                LocalDate.parse(by);
            } catch (Exception e) {
                throw new AeromonException(String.format("I need a new date with the correct format please :/"));
            }
        } else if (taskType.equals("Event")) {
            try {
                String[] arr = description.split(" /at ");
                String by = arr[1].trim();
                LocalDate.parse(by);
            } catch (Exception e) {
                throw new AeromonException(String.format("I need a new date with the correct format please :/"));
            }
        }
        return description;
    }

    private static int getTaskNum(String s) throws AeromonException {
        String taskNum = s.trim();
        if (taskNum.isEmpty()) {
            throw new AeromonException("Why is the task number empty?");
        } else {
            return Integer.parseInt(taskNum);
        }
    }
}
