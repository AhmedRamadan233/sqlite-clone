package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategyInterface;

public class DeleteStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("DELETE");
        return PrepareResult.SUCCESS;
    }
}
