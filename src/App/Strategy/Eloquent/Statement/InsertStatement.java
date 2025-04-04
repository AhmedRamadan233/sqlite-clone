package App.Strategy.Eloquent.Statement;

import App.Models.Row;
import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

import java.util.ArrayList;
import java.util.List;

public class InsertStatement implements StatementStrategyInterface {
    private static final List<Row> rows = new ArrayList<>();

    @Override
    public PrepareResult execute(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 4) {
            System.out.println("Insert failed");
            return PrepareResult.SYNTAX_ERROR;
        }

        try {
            int id = Integer.parseInt(parts[1]);
            String username = parts[2];
            String email = parts[3];

            Row row = new Row(id, username, email);
            rows.add(row);

            System.out.println("Inserted: " + row);
            return PrepareResult.SUCCESS;
        } catch (NumberFormatException e) {
            System.out.println("Insert failed");
            return PrepareResult.SYNTAX_ERROR;
        }
    }

//    public static List<Row> getRows() {
//        return rows;
//    }


}
