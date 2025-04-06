package App.Models;

import App.Database.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class Row {
    int id;
    String username;
    String email;
    private static final Logger LOGGER = Logger.getLogger(Row.class.getName());

    public Row(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public byte[] serialize() {
       // LOGGER.info("Entered serialize() method for Row with id: " + id);

        ByteBuffer buffer = ByteBuffer.allocate(Constants.ROW_SIZE);
        buffer.putInt(id);
        buffer.put(username.getBytes(StandardCharsets.UTF_8), 0, Math.min(username.length(), Constants.USERNAME_SIZE));
        buffer.position(Constants.ID_SIZE + Constants.USERNAME_SIZE);
        buffer.put(email.getBytes(StandardCharsets.UTF_8), 0, Math.min(email.length(),Constants.EMAIL_SIZE));
        return buffer.array();
    }

    public static Row deserialize(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int id = buffer.getInt();

     //   LOGGER.info("Entered deserialize() method for Row with id: " + id);

        byte[] usernameBytes = new byte[Constants.USERNAME_SIZE];
        buffer.get(usernameBytes);
        byte[] emailBytes = new byte[Constants.EMAIL_SIZE];
        buffer.get(emailBytes);

        String username = new String(usernameBytes, StandardCharsets.UTF_8).trim();
        String email = new String(emailBytes, StandardCharsets.UTF_8).trim();
        return new Row(id, username, email);
    }

    @Override
    public String toString() {
        return String.format("Row{id=%d, username='%s', email='%s'}", id, username, email);
    }
}

