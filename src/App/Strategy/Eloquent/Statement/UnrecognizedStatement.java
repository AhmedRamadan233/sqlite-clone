package App.Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class UnrecognizedStatement implements StatementStrategyInterface {
    @Override
    public PrepareResult execute(String input) {
        System.out.println("UnrecognizedStatement");
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}
