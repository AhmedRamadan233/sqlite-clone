package App.Factory;

import App.Database.Table;
import App.Strategy.Eloquent.MetaCommand.ExitCommand;
import App.Strategy.Eloquent.MetaCommand.HelpCommand;
import App.Strategy.Eloquent.MetaCommand.UnrecognizedCommand;
import App.Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;
import java.util.logging.Logger;

import java.util.HashMap;
import java.util.Map;

public class MetaCommandFactory {
    private static final Logger LOGGER = Logger.getLogger(MetaCommandFactory.class.getName());

    private static final Map<String, MetaCommandStrategyInterface> SINGLETON_COMMAND_MAP = new HashMap<>();
    private static final Map<String, Class<? extends MetaCommandStrategyInterface>> BIND_COMMAND_MAP = new HashMap<>();


    public static void initialize(Table table) {
        Singlton(".EXIT", new ExitCommand(table));
        Singlton(".HELP", new HelpCommand());
    }

    public static MetaCommandStrategyInterface createMetaCommand(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedCommand();
        }
        String upperInput = input.toUpperCase().split(" ")[0];
        if (SINGLETON_COMMAND_MAP.containsKey(upperInput)) {
            return SINGLETON_COMMAND_MAP.get(upperInput);
        }

        if (BIND_COMMAND_MAP.containsKey(upperInput)) {
            try {
                return BIND_COMMAND_MAP.get(upperInput).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                LOGGER.severe("Error creating instance for command: " + upperInput + " - " + e.getMessage());
                return new UnrecognizedCommand();
            }
        }

        return new UnrecognizedCommand();
    }


    public static void Singlton(String command, MetaCommandStrategyInterface metaCommand) {
        SINGLETON_COMMAND_MAP.put(command.toUpperCase(), metaCommand);
    }
    public static void Bind(String command, Class<? extends MetaCommandStrategyInterface> strategyClass) {
        BIND_COMMAND_MAP.put(command.toUpperCase(), strategyClass);
    }
}
