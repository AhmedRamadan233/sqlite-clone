package Helpers;

import Buffer.InputBuffer;
import Enums.MetaCommandResult;

public class MetaCommandHandler {

    public static MetaCommandResult doMetaCommand(String input, InputBuffer inputBuffer) {
        if (input.equals(".exit")) {
            inputBuffer.closeInputBuffer();
            System.out.println("Exiting...");
            System.exit(0);
            return MetaCommandResult.SUCCESS;
        }
        return MetaCommandResult.UNRECOGNIZED_COMMAND;
    }
}
