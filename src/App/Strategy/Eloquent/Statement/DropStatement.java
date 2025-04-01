package App.Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class DropStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute(String input) {
        System.out.println("Drop");
        return PrepareResult.SUCCESS;
    }
}
