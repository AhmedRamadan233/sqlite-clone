package Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import Strategy.Interfaces.MetaCommand.MetaCommandInterface;

public class HelpCommand implements MetaCommandInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Help");
        return PrepareResult.SUCCESS;
    }
}
