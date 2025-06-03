package App.Providers;
import App.Container.StatementContainer;
import App.Database.Table;
import App.Strategy.Eloquent.Statement.*;
import java.util.logging.Logger;

public class StatementServiceProvider {
    private static final Logger LOGGER = Logger.getLogger(StatementServiceProvider.class.getName());
    public static void register(Table table) {
        StatementContainer.Singlton("INSERT", new InsertStatement(table));
        StatementContainer.Singlton("UPDATE", new UpdateStatement());
        StatementContainer.Singlton("DELETE", new DeleteStatement());
        StatementContainer.Singlton("DROP", new DropStatement());
        StatementContainer.Bind("SELECT", () -> new SelectStatement(table));
    }
    public static void boot() {
        LOGGER.info("StatementServiceProvider booted. All statements registered.");
    }
}
