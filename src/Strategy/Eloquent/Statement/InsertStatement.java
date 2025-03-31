package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class InsertStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("INSERT");
        return PrepareResult.SUCCESS;
    }
}
