import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void greet() {
        System.out.println("Hey, Aeromon here! Fancy a cup of tea?");
    }
}
