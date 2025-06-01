package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTests {

    @Test
    public void testInsertAndSelect() throws Exception {
        List<String> result = DatabaseTestHelper.runScript(List.of(
                "insert 1 user1 person1@example.com",
                "select",
                ".exit"
        ));

        assertTrue(result.contains("Executed."));
        assertTrue(result.contains("(1, user1, person1@example.com)"));
    }
    @Test
    public void testTableFull() throws Exception {
        List<String> script = new ArrayList<>();
        for (int i = 1; i <= 1401; i++) {
            script.add("insert " + i + " user" + i + " person" + i + "@example.com");
        }
        script.add(".exit");

        List<String> result = DatabaseTestHelper.runScript(script);

        assertTrue(result.contains("Error: Table full."));
    }

}