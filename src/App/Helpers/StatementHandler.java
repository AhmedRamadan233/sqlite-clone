package App.Helpers;

import App.Database.Table;
import Buffer.InputBuffer;
import Enums.PrepareResult;

import App.Factory.StatementFactory;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class StatementHandler {
    public static PrepareResult prepareStatement(String input) {
        StatementStrategyInterface strategy = StatementFactory.createStatement(input);
        if (strategy != null) {
            return strategy.execute(input);
        }
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }
}


