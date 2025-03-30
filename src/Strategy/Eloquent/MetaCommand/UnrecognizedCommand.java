package Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import Strategy.Interfaces.MetaCommand.MetaCommandInterface;

public class UnrecognizedCommand implements MetaCommandInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Unrecognized command AHMED RAMADAN IBRAHIM");
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
