package Factory;

import Strategy.Eloquent.MetaCommand.ExitCommand;
import Strategy.Eloquent.MetaCommand.HelpCommand;
import Strategy.Eloquent.MetaCommand.UnrecognizedCommand;
import Strategy.Eloquent.Statement.UnrecognizedStatement;
import Strategy.Interfaces.MetaCommand.MetaCommandInterface;

import java.util.HashMap;
import java.util.Map;

public class MetaCommandFactory {
    private static final Map<String, MetaCommandInterface> COMMAND_MAP = new HashMap<>();

    static {
        registerMetaCommand(".EXIT", new ExitCommand());
        registerMetaCommand(".HELP", new HelpCommand());
    }

    public static void registerMetaCommand(String command, MetaCommandInterface metaCommand) {
        COMMAND_MAP.put(command.toUpperCase(), metaCommand);
    }

    public static MetaCommandInterface createMetaCommand(String input) {
        if (input == null || input.isEmpty()) {
            return new UnrecognizedCommand();
        }

        String upperInput = input.toUpperCase().split(" ")[0];
        return COMMAND_MAP.getOrDefault(upperInput, null);
    }
}
