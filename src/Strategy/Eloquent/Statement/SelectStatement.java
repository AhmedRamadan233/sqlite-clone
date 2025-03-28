package Strategy.Eloquent.Statement;

import Enums.PrepareResult;
import Strategy.Interfaces.Statement.StatementStrategy;

public class SelectStatement implements StatementStrategy {
    @Override
    public PrepareResult execute() {
        System.out.print("Romiooooooooooooooo");
        return PrepareResult.SUCCESS;
    }
}
