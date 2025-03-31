package Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

public class UnrecognizedCommand implements MetaCommandStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Unrecognized command AHMED RAMADAN IBRAHIM");
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
