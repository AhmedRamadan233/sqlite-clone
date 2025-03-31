package Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

public class HelpCommandStrategy implements MetaCommandStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Help");
        return PrepareResult.SUCCESS;
    }
}
