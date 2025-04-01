package App.Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import App.Strategy.Interfaces.MetaCommand.MetaCommandStrategyInterface;

public class ExitCommand implements MetaCommandStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Exiting...");
        System.out.flush();
        System.exit(0);
        return PrepareResult.EXIT;
    }
}
