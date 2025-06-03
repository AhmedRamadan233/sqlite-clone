package App.Container;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class StatementContainer {
    private static final Map<String, StatementStrategyInterface> singletonBindings = new HashMap<>();
    private static final Map<String, Supplier<StatementStrategyInterface>> suppliers = new HashMap<>();
    public static void Singlton(String command, StatementStrategyInterface strategy) {
        singletonBindings.put(command.toUpperCase(), strategy);
    }
    public static void Bind(String command, Supplier<StatementStrategyInterface> supplier) {
        suppliers.put(command.toUpperCase(), supplier);
    }
    public static StatementStrategyInterface resolve(String command) {
        String key = command.toUpperCase().split(" ")[0];
        if (singletonBindings.containsKey(key)) {
            return singletonBindings.get(key);
        }
        if (suppliers.containsKey(key)) {
            return suppliers.get(key).get();
        }
        return null;
    }
}
