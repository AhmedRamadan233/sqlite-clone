package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class DeleteStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        System.out.print("DELETE");
        return PrepareResult.SUCCESS;
    }
}
