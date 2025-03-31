package REPL;
import Buffer.InputBuffer;
import Helpers.MetaCommandHandler;
import Helpers.StatementHandler;

import java.util.Scanner;

public class Repl {
    private Scanner scanner;
    private InputBuffer inputBuffer;

    public Repl() {
        scanner = new Scanner(System.in);
        inputBuffer = new InputBuffer();

    }
    private void printPrompt() {
        System.out.print("db > ");
    }

    public void start() {
        System.out.println("Welcome to Sqlite Clone!");
        while (true) {
            printPrompt();
            inputBuffer.readInput(scanner);
            String input = inputBuffer.getBuffer();

            if (input.startsWith(".")) {
                 MetaCommandHandler.doMetaCommand(input, inputBuffer);
            }else {
                StatementHandler.prepareStatement(input, inputBuffer);
            }
        }
    }
}
