package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class UnrecognizedStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("UnrecognizedStatement");
        return PrepareResult.SUCCESS;
    }
}
