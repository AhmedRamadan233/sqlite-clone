package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class UpdateStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        System.out.print("UPDATE");
        return PrepareResult.SUCCESS;
    }
}
