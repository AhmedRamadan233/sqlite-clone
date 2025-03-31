package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class SelectStatement implements StatementStrategyInterface{
    @Override
    public PrepareResult execute() {
        System.out.println("SELECT");
        return PrepareResult.SUCCESS;
    }
}

