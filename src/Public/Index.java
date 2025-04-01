package Public;
import Buffer.InputBuffer;
import Enums.PrepareResult;
import App.Helpers.MetaCommandHandler;
import App.Helpers.StatementHandler;

import java.util.Scanner;

public class Index {
    private Scanner scanner;
    private InputBuffer inputBuffer;

    public Index() {
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
            PrepareResult result;
            if (input.startsWith(".")) {
                result =  MetaCommandHandler.doMetaCommand(input, inputBuffer);
            }else {
                result =  StatementHandler.prepareStatement(input, inputBuffer);
            }
            if (result == PrepareResult.UNRECOGNIZED_COMMAND) {
                System.out.println("Unrecognized command!");
            }
            if (result == PrepareResult.EXIT) {
                System.out.println("Bye!");
                break;
            }
        }
    }
}
