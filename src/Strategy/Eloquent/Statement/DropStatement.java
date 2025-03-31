package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class DropStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Drop");
        return PrepareResult.SUCCESS;
    }
}
