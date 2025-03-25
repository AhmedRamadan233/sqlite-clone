package REPL;
import Buffer.InputBuffer;
import Enums.MetaCommandResult;
import Enums.PrepareResult;
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
                MetaCommandResult result = MetaCommandHandler.doMetaCommand(input, inputBuffer);
                if (result == MetaCommandResult.SUCCESS) {
                    continue;
                } else {
                    System.out.println("Unrecognized command: " + input);
                    continue;
                }
            }
            PrepareResult statementResult = StatementHandler.prepareStatement(input, inputBuffer);

            if (statementResult == PrepareResult.SUCCESS) {
                System.out.println("SQL command processed successfully: " + input);
            } else {
                System.out.println("Unrecognized SQL command: " + input);
            }


            //scanner.close();
        }
    }
}
