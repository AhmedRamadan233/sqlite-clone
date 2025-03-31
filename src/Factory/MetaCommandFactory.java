package Factory;

import Strategy.Eloquent.MetaCommand.ExitCommandStrategy;
import Strategy.Eloquent.MetaCommand.HelpCommandStrategy;
import Strategy.Eloquent.MetaCommand.UnrecognizedCommandStrategy;
import Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

import java.util.HashMap;
import java.util.Map;

public class MetaCommandFactory {
    private static final Map<String, MetaCommandStrategyInterface> COMMAND_MAP = new HashMap<>();

    static {
        registerMetaCommand(".EXIT", new ExitCommandStrategy());
        registerMetaCommand(".HELP", new HelpCommandStrategy());
    }
    public static void registerMetaCommand(String command, MetaCommandStrategyInterface metaCommand) {
        COMMAND_MAP.put(command.toUpperCase(), metaCommand);
    }
    public static MetaCommandStrategyInterface createMetaCommand(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedCommandStrategy();
        }
        String upperInput = input.toUpperCase().split(" ")[0];
        return COMMAND_MAP.getOrDefault(upperInput, new UnrecognizedCommandStrategy());
    }
}
