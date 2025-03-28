package Helpers;

import Buffer.InputBuffer;
import Enums.PrepareResult;
import Factory.StatementFactory;
import Strategy.Interfaces.Statement.StatementStrategy;

public class StatementHandler {
    public static PrepareResult prepareStatement(String input, InputBuffer inputBuffer) {
        StatementStrategy strategy = StatementFactory.createStatement(input);
        return strategy.execute();
    }

}