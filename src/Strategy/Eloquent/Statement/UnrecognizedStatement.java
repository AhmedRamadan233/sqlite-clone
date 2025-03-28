package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class UnrecognizedStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
