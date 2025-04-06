package App.Database;

public class Table {
    private int numRows = 0;
    private final byte[][] pages = new byte[Constants.TABLE_MAX_PAGES][];

    public int getNumRows() {
        return numRows;
    }

    public void incrementNumRows() {
        numRows++;
    }

    public byte[] rowSlot(int rowNum) {
        int pageNum = rowNum / Constants.ROWS_PER_PAGE;
        if (pages[pageNum] == null) {
            pages[pageNum] = new byte[Constants.PAGE_SIZE];
        }

        int rowOffset = rowNum % Constants.ROWS_PER_PAGE;
        int byteOffset = rowOffset * Constants.ROW_SIZE;

        byte[] page = pages[pageNum];

        byte[] slot = new byte[Constants.ROW_SIZE];
        System.arraycopy(page, byteOffset, slot, 0, Constants.ROW_SIZE);

        return slot;
    }

    public void writeRow(int rowNum, byte[] serializedRow) {
        int pageNum = rowNum / Constants.ROWS_PER_PAGE;

        if (pages[pageNum] == null) {
            pages[pageNum] = new byte[Constants.PAGE_SIZE];
        }

        int rowOffset = rowNum % Constants.ROWS_PER_PAGE;
        int byteOffset = rowOffset * Constants.ROW_SIZE;

        byte[] page = pages[pageNum];

        System.arraycopy(serializedRow, 0, page, byteOffset, Constants.ROW_SIZE);
    }

    public byte[][] getPages() {
        return pages;
    }
}
