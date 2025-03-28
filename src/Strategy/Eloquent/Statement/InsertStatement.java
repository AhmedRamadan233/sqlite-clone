package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class InsertStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        System.out.print("INSERT");
        return PrepareResult.SUCCESS;
    }
}
