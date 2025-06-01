package App.Database;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Pager {
    private RandomAccessFile file;
    private int fileLength;
    private byte[][] pages = new byte[Constants.TABLE_MAX_PAGES][];




    public Pager(String filename) throws IOException {
        this.file = new RandomAccessFile(filename, "rw");
        this.fileLength = (int) file.length();
        
    }

    public byte[][] getPages() {
        return pages;
    }

    public RandomAccessFile getFile() {
        return file;
    }

    public int getFileLength() {
        return fileLength;
    }

    public byte[] getPage(int pageNum) {
        if (pages[pageNum] == null) {
            pages[pageNum] = new byte[Constants.PAGE_SIZE];
        }
        return pages[pageNum];
    }
}
