package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class dataproviders {

    // DataProvider for login data
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        // Path to your Excel file
        String path = ".\\TestData\\login_data.xlsx";

        // Create ExcelUtility object
        Utilities xlutil = new Utilities(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        // Exclude header row, hence totalrows - 1
        String logindata[][] = new String[totalrows - 1][totalcols];

        // Start from row 1 (skip header at row 0)
        for (int i = 1; i < totalrows; i++) {
            for (int j = 0; j < totalcols; j++) {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return logindata;   // return 2D array
    }
}
