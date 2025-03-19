package REPL;
import java.util.Scanner;

public class Repl {
    private Scanner scanner;
    private InputBuffer inputBuffer;
    public Repl() {
        scanner = new Scanner(System.in);
        inputBuffer = new InputBuffer();

    }

    private void printPrompt() {
        System.out.print("db > "); // طباعة الـ prompt
    }
    public void start(){
        System.out.println("Welcome to Sqlite Clone!");
        while (true) {
            printPrompt();
            inputBuffer.readInput(scanner);

            String input = inputBuffer.getBuffer();

            if (input.equals(".exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Unrecognized command: " + input);
            }
        }
        scanner.close();
    }

}
