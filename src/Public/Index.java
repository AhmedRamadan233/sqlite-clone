package Public;
import App.Container.StatementContainer;
import App.Database.Pager;
import App.Database.Table;
import App.Factory.MetaCommandFactory;
import App.Factory.StatementFactory;
import App.Helpers.DBHelper;
import Buffer.InputBuffer;
import Enums.PrepareResult;
import App.Helpers.MetaCommandHandler;
import App.Helpers.StatementHandler;

import java.io.IOException;
import java.util.Scanner;

import App.Providers.StatementServiceProvider;


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
        try {
            Pager pager = new Pager("myDatabase.txt");
            Table table = new Table(pager);
            StatementContainer.bindDependency(Table.class, table);
            StatementServiceProvider.register();
            StatementServiceProvider.boot();


            MetaCommandFactory.initialize(table);

            System.out.println("Welcome to Sqlite Clone!");
            while (true) {
                printPrompt();
                inputBuffer.readInput(scanner);
                String input = inputBuffer.getBuffer();
                PrepareResult result;
                if (input.startsWith(".")) {
                    result =  MetaCommandHandler.doMetaCommand(input);
                }else {
                    result = StatementHandler.prepareStatement(input);
                }
                if (result == PrepareResult.UNRECOGNIZED_COMMAND) {
                    System.out.println("Unrecognized command!");
                }
                if (result == PrepareResult.EXIT) {

                    System.out.println("Bye!");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
