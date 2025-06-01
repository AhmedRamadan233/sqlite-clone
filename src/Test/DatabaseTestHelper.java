package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTestHelper {

    public static List<String> runScript(List<String> commands) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("java", "Public.Index");
        Process process = builder.start();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        for (String command : commands) {
            writer.write(command);
            writer.newLine();
        }

        writer.flush();
        writer.close();

        List<String> output = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            output.add(line);
        }

        return output;
    }
}

