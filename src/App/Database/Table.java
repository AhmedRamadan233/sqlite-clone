package App.Database;

public class Table {
    private final Pager pager;
    private int numRows = 0;

    public Table(Pager pager) {
        this.pager = pager;
    }

    public int getNumRows() {
        return numRows;
    }


    public void incrementNumRows() {
        numRows++;
    }

    public byte[] rowSlot(int rowNum) {
        int pageNum = rowNum / Constants.ROWS_PER_PAGE;

        byte[][] pages = pager.getPages();
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

        byte[][] pages = pager.getPages();
        if (pages[pageNum] == null) {
            pages[pageNum] = new byte[Constants.PAGE_SIZE];
        }

        int rowOffset = rowNum % Constants.ROWS_PER_PAGE;
        int byteOffset = rowOffset * Constants.ROW_SIZE;

        byte[] page = pages[pageNum];
        System.arraycopy(serializedRow, 0, page, byteOffset, Constants.ROW_SIZE);
    }

    public Pager getPager() {
        return pager;
    }

    public int getRowsPerPage() {
        return Constants.ROWS_PER_PAGE;
    }


}
