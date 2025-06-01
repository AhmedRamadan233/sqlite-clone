package App.Strategy.Eloquent.MetaCommand;

import App.Database.Table;
import App.Helpers.DBHelper;
import Enums.PrepareResult;
import App.Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

import java.io.IOException;

public class ExitCommand implements MetaCommandStrategyInterface {
    private final Table table;

    public ExitCommand(Table table) {
        this.table = table;
    }

    @Override
    public PrepareResult execute() {
        try {
            System.out.println("Before...");
            DBHelper.dbClose(table);
            System.out.println("Exiting...");
            System.out.flush();
            System.exit(0);
            return PrepareResult.EXIT;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
