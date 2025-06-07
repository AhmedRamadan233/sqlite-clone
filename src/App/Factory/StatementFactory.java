package App.Factory;

import App.Container.StatementContainer;
import App.Strategy.Eloquent.Statement.UnrecognizedStatement;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

import java.util.Optional;
import java.util.logging.Logger;

public class StatementFactory {
    private static final Logger LOGGER = Logger.getLogger(StatementFactory.class.getName());

    public static StatementStrategyInterface createStatement(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedStatement();
        }

        try {
            StatementStrategyInterface resolved = StatementContainer.resolve(input);
            return resolved != null ? resolved : new UnrecognizedStatement();
        } catch (Exception e) {
            LOGGER.severe("Error resolving statement: " + input + " - " + e.getMessage());
            return new UnrecognizedStatement();
        }
    }

    public static <T> T make(Class<T> iface) {
        try {
            return Optional.ofNullable(StatementContainer.resolve(iface))
                    .orElseThrow(() -> new RuntimeException("No binding found for interface: " + iface.getName()));
        } catch (Exception e) {
            LOGGER.severe("Error resolving interface: " + iface.getName() + " - " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
