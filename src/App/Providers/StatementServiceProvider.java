package App.Providers;
import App.Container.StatementContainer;

import App.Strategy.Eloquent.Statement.*;
import java.util.logging.Logger;

public class StatementServiceProvider {
    private static final Logger LOGGER = Logger.getLogger(StatementServiceProvider.class.getName());

    public static void register() {
        StatementContainer.Singlton("INSERT", InsertStatement.class);
        StatementContainer.Singlton("UPDATE", UpdateStatement.class);
        StatementContainer.Singlton("DELETE", DeleteStatement.class);
        StatementContainer.Singlton("DROP", DropStatement.class);
        StatementContainer.Bind("SELECT", SelectStatement.class);
    }


    public static void boot() {
        LOGGER.info("StatementServiceProvider booted. All statements registered.");

    }
}
