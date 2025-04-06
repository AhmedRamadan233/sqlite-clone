package App.Strategy.Eloquent.Statement;

import App.Database.Table;
import App.Models.Row;
import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class SelectStatement implements StatementStrategyInterface{
    private final Table table;

    public SelectStatement(Table table) {
        this.table = table;
    }
    @Override
    public PrepareResult execute(String input) {
        for (int i = 0; i < table.getNumRows(); i++) {
            byte[] slot = table.rowSlot(i);
            Row row = Row.deserialize(slot);

            System.out.println(row +" "+ table.getNumRows());
        }

        return PrepareResult.SUCCESS;
    }
}

