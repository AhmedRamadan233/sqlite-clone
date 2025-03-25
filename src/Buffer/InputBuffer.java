package Buffer;

import java.util.Scanner;

public class InputBuffer {
    private String buffer;
    private int bufferLength;
    private int inputLength;

    public InputBuffer() {
        this.buffer = "";
        this.bufferLength = 0;
        this.inputLength = 0;
    }
    public void readInput(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            System.out.println("Error reading input");
            System.exit(1);
        }

        this.buffer = scanner.nextLine();
        this.inputLength = buffer.length();
        this.bufferLength = buffer.length();
    }
    public void closeInputBuffer() {
        this.buffer = null;
    }
    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
        this.inputLength = buffer.length();
        this.bufferLength = buffer.length();
    }

    public int getBufferLength() {
        return bufferLength;
    }

    public int getInputLength() {
        return inputLength;
    }
}
