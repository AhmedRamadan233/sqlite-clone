package App.Models;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Row {
    static final int ID_SIZE = Integer.BYTES;
    static final int USERNAME_SIZE = 32;
    static final int EMAIL_SIZE = 255;
    static final int ROW_SIZE = ID_SIZE + USERNAME_SIZE + EMAIL_SIZE;

    int id;
    String username;
    String email;

    public Row(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public byte[] serialize() {
        ByteBuffer buffer = ByteBuffer.allocate(ROW_SIZE);
        buffer.putInt(id);
        buffer.put(username.getBytes(StandardCharsets.UTF_8), 0, Math.min(username.length(), USERNAME_SIZE));
        buffer.position(ID_SIZE + USERNAME_SIZE);
        buffer.put(email.getBytes(StandardCharsets.UTF_8), 0, Math.min(email.length(), EMAIL_SIZE));
        return buffer.array();
    }

    public static Row deserialize(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        int id = buffer.getInt();
        byte[] usernameBytes = new byte[USERNAME_SIZE];
        buffer.get(usernameBytes);
        byte[] emailBytes = new byte[EMAIL_SIZE];
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

