package Factory;

import Strategy.Eloquent.MetaCommand.ExitCommand;
import Strategy.Eloquent.MetaCommand.HelpCommand;
import Strategy.Eloquent.MetaCommand.UnrecognizedCommand;
import Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

import java.util.HashMap;
import java.util.Map;

public class MetaCommandFactory {
    private static final Map<String, MetaCommandStrategyInterface> COMMAND_MAP = new HashMap<>();

    static {
        registerMetaCommand(".EXIT", new ExitCommand());
        registerMetaCommand(".HELP", new HelpCommand());
    }
    public static void registerMetaCommand(String command, MetaCommandStrategyInterface metaCommand) {
        COMMAND_MAP.put(command.toUpperCase(), metaCommand);
    }
    public static MetaCommandStrategyInterface createMetaCommand(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedCommand();
        }
        String upperInput = input.toUpperCase().split(" ")[0];
        return COMMAND_MAP.getOrDefault(upperInput, new UnrecognizedCommand());
    }
}
