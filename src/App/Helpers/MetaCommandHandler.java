package App.Helpers;

import Buffer.InputBuffer;

import Enums.PrepareResult;
import App.Factory.MetaCommandFactory;
import App.Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

public class MetaCommandHandler {

    public static PrepareResult doMetaCommand(String input) {
        MetaCommandStrategyInterface command = MetaCommandFactory.createMetaCommand(input);
        if (command != null) {
            return command.execute();
        }
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
