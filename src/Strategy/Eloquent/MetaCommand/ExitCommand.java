package Strategy.Eloquent.MetaCommand;

import Enums.PrepareResult;
import Strategy.Interfaces.MetaCommand.MetaCommandInterface;

public class ExitCommand implements MetaCommandInterface {
    @Override
    public PrepareResult execute() {
        System.out.println("Exiting...");
        System.out.flush();
        System.exit(0);
        return PrepareResult.SUCCESS;
    }
}
