package App.Factory;

import App.Database.Table;
import App.Strategy.Eloquent.Statement.*;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class StatementFactory {
    private static final Logger LOGGER = Logger.getLogger(StatementFactory.class.getName());

    private static final Map<String, StatementStrategyInterface> SINGLETON_STATEMENT_MAP = new HashMap<>();

    private static final Map<String, Supplier<StatementStrategyInterface>> BIND_STATEMENTS_SUPPLIERS = new HashMap<>();

    public static void initialize(Table table) {
        Singlton("INSERT", new InsertStatement(table));
        Singlton("UPDATE", new UpdateStatement());
        Singlton("DELETE", new DeleteStatement());
        Singlton("DROP", new DropStatement());

        Bind("SELECT", () -> new SelectStatement(table));
    }

    public static StatementStrategyInterface createStatement(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedStatement();
        }

        String upperInput = input.toUpperCase().split(" ")[0];

        if (SINGLETON_STATEMENT_MAP.containsKey(upperInput)) {
            return SINGLETON_STATEMENT_MAP.get(upperInput);
        }

        if (BIND_STATEMENTS_SUPPLIERS.containsKey(upperInput)) {
            try {
                return BIND_STATEMENTS_SUPPLIERS.get(upperInput).get();
            } catch (Exception e) {
                LOGGER.severe("Error creating instance for statement: " + upperInput + " - " + e.getMessage());
                return new UnrecognizedStatement();
            }
        }

        return new UnrecognizedStatement();
    }

    public static void Singlton(String command, StatementStrategyInterface strategy) {
        SINGLETON_STATEMENT_MAP.put(command.toUpperCase(), strategy);
    }

    public static void Bind(String command, Supplier<StatementStrategyInterface> supplier) {
        BIND_STATEMENTS_SUPPLIERS.put(command.toUpperCase(), supplier);
    }
}
