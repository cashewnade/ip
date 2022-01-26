import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File localTasks;

    public Storage(String fileLocation) {
        this.localTasks = new File(fileLocation);
    }

    public ArrayList<Task> getFile() throws AeromonException {
        try {
            if (localTasks.createNewFile()) {
                return new ArrayList<>();
            } else {
                ArrayList<Task> tasks = new ArrayList<>();
                Scanner fileScanner = new Scanner(localTasks);

                while (fileScanner.hasNextLine()) {
                    String content = fileScanner.nextLine();
                    String[] info = content.split(" / ");
                    switch (info[0]) {
                        case "T": {
                            ToDo task = new ToDo(info[2]);
                            tasks.add(task);
                            break;
                        }
                        case "D": {
                            Deadline task = new Deadline(info[2], LocalDate.parse(info[3]));
                            tasks.add(task);
                            break;
                        }
                        case "E": {
                            Event task = new Event(info[2], LocalDate.parse(info[3]));
                            tasks.add(task);
                            break;
                        }
                    }
                }
                fileScanner.close();
                return tasks;
            }
        } catch (IOException e) {
            throw new AeromonException("Ohnoz! Something went terribly wrong!");
        }
    }

    public void saveFile(ArrayList<Task> tasks) {
        String content = "";
        for (int i = 0; i < tasks.size(); i++) {
            content += tasks.get(i).toOutputFormat() + "\n";
        }

        try {
            FileWriter fileWriter = new FileWriter("./data/localTasks.txt");
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Ohnoz! Something went terribly wrong!");
            e.printStackTrace();
        }
    }
}
