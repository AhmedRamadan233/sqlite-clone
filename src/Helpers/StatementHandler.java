package Helpers;

import Buffer.InputBuffer;
import Enums.PrepareResult;
import Enums.StatementType;

public class StatementHandler {
    public static PrepareResult prepareStatement(String input, InputBuffer inputBuffer) {
        StatementType statementType = getStatementType(input);

        switch (statementType) {
            case SELECT:
                System.out.print("Romio");
                return PrepareResult.SUCCESS;

            case INSERT:
                System.out.print("INSERT");
                return PrepareResult.SUCCESS;

            case UPDATE:
                System.out.print("UPDATE");
                return PrepareResult.SUCCESS;

            case DELETE:
                System.out.print("DELETE");
                return PrepareResult.SUCCESS;

            default:
                return PrepareResult.UNRECOGNIZED_COMMAND;
        }
    }

    private static StatementType getStatementType(String input) {
        if (input == null || input.isEmpty()) {
            return StatementType.UNKNOWN;
        }

        String upperInput = input.toUpperCase();

        if (upperInput.startsWith("SELECT")) {
            return StatementType.SELECT;
        } else if (upperInput.startsWith("INSERT")) {
            return StatementType.INSERT;
        } else if (upperInput.startsWith("UPDATE")) {
            return StatementType.UPDATE;
        } else if (upperInput.startsWith("DELETE")) {
            return StatementType.DELETE;
        }

        return StatementType.UNKNOWN;
    }
}