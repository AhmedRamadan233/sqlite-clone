package App.Strategy.Eloquent.Statement;

import App.Database.Constants;
import App.Database.Table;
import App.Models.Row;
import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class InsertStatement implements StatementStrategyInterface {
    private final Table table;

    public InsertStatement(Table table) {
        this.table = table;
    }

    @Override
    public PrepareResult execute(String input) {
        String[] parts = input.trim().split(" ");

        if (parts.length != 4) {
            System.out.println("Insert failed: Invalid syntax");
            return PrepareResult.SYNTAX_ERROR;
        }

        try {
            int id = Integer.parseInt(parts[1]);
            String username = parts[2];
            String email = parts[3];

            Row row = new Row(id, username, email);
            byte[] serializedRow = row.serialize();

            // Check if table is full
            if (table.getNumRows() >= Constants.TABLE_MAX_ROWS) {
                System.out.println("Insert failed: Table full.");
                return PrepareResult.TABLE_FULL;
            }

            // Write to the table
            table.writeRow(table.getNumRows(), serializedRow);
            table.incrementNumRows();


            // Optional: Print for debug
            Row deserialized = Row.deserialize(serializedRow);
            System.out.println("Inserted (after deserialize): " + deserialized);

            return PrepareResult.SUCCESS;
        } catch (NumberFormatException e) {
            System.out.println("Insert failed: ID must be a number");
            return PrepareResult.SYNTAX_ERROR;
        }
    }
}
