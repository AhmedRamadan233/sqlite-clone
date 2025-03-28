package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class DropStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        System.out.print("Drop");
        return PrepareResult.SUCCESS;
    }
}
