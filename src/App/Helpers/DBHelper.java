package App.Helpers;

import App.Database.Constants;
import App.Database.Pager;
import App.Database.Table;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DBHelper {

    public static void dbClose(Table table) throws IOException {
        Pager pager = table.getPager();
        int numFullPages = table.getNumRows() / Constants.ROWS_PER_PAGE;

        for (int i = 0; i < numFullPages; i++) {
            if (pager.getPages()[i] == null) {
                continue;
            }
            pager.getFile().seek(i * Constants.PAGE_SIZE);
            pager.getFile().write(pager.getPages()[i]);
        }

        // Handle partially full page
        int numAdditionalRows = table.getNumRows() % Constants.ROWS_PER_PAGE;
        if (numAdditionalRows > 0) {
            int pageNum = numFullPages;
            if (pager.getPages()[pageNum] != null) {
                pager.getFile().seek(pageNum * Constants.PAGE_SIZE);
                pager.getFile().write(pager.getPages()[pageNum]);
            }
        }

        pager.getFile().close();
    }
}

