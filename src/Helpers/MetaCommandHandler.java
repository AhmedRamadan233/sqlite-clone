package Helpers;

import Buffer.InputBuffer;

import Enums.PrepareResult;
import Factory.MetaCommandFactory;
import Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

public class MetaCommandHandler {

    public static PrepareResult doMetaCommand(String input, InputBuffer inputBuffer) {
        MetaCommandStrategyInterface command = MetaCommandFactory.createMetaCommand(input);
        if (command != null) {
            return command.execute();
        }
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
