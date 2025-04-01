package App.Helpers;

import Buffer.InputBuffer;
import Enums.PrepareResult;

import App.Factory.StatementFactory;
import App.Strategy.Interfaces.Statement.StatementStrategyInterface;

public class StatementHandler {
    public static PrepareResult prepareStatement(String input, InputBuffer inputBuffer) {
        StatementStrategyInterface strategy = StatementFactory.createStatement(input);
        if (strategy != null) {
            return strategy.execute();
        }
        return PrepareResult.UNRECOGNIZED_COMMAND;
    }

}