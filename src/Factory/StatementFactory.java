package Factory;

import Strategy.Eloquent.Statement.*;
import Strategy.Interfaces.Statement.StatementStrategy;

import java.util.HashMap;
import java.util.Map;

public class StatementFactory {
    private static final Map<String, StatementStrategy> STATEMENT_MAP = new HashMap<>();

    static {
        registerStatement("SELECT", new SelectStatement());
        registerStatement("INSERT", new InsertStatement());
        registerStatement("UPDATE", new UpdateStatement());
        registerStatement("DELETE", new DeleteStatement());
        registerStatement("DROP", new DropStatement());
    }

    public static StatementStrategy createStatement(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedStatement();
        }

        String upperInput = input.toUpperCase().split(" ")[0];
        return STATEMENT_MAP.getOrDefault(upperInput, new UnrecognizedStatement());
    }

    public static void registerStatement(String command, StatementStrategy strategy) {
        STATEMENT_MAP.put(command.toUpperCase(), strategy);
    }
}
