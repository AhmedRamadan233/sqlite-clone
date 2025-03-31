package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class UpdateStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("UPDATE");
        return PrepareResult.SUCCESS;
    }
}
