package App.Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class UpdateStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute(String input) {
        System.out.println("UPDATE");
        return PrepareResult.SUCCESS;
    }
}
