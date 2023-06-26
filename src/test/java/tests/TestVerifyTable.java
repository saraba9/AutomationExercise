package tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import pages.HtmlTablesPage;
import general.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class TestVerifyTable {
    private int searchColumn;
    private String searchText;
    private int returnColumnText;
    private String expectedText;

    public TestVerifyTable(int searchColumn, String searchText, int returnColumnText, String expectedText) {
        this.searchColumn = searchColumn;
        this.searchText = searchText;
        this.returnColumnText = returnColumnText;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        try {
            int NumDataItem = Utils.getNumDataItem("verifyCell");
            for (int i = 0; i < NumDataItem; i++) {

                data.add(new Object[]{Integer.parseInt(Utils.getDataItem("searchColumn", i)), Utils.getDataItem("searchText", i)
                        , Integer.parseInt(Utils.getDataItem("returnColumnText", i)),Utils.getDataItem("expectedText", i)});

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @BeforeClass
    public static void beforeClass() {
        Browser.driver().get(Constants.URL);
    }

    @Test
    public void test()  {
        HtmlTablesPage htmlTablesPage= new HtmlTablesPage();
        WebElement table= htmlTablesPage.getCustomerTable();
        boolean result = htmlTablesPage.verifyTableCellText(table,searchColumn,searchText,returnColumnText,expectedText);
        Assert.assertTrue("Test failed", result);
    }

    @AfterClass
    public static void afterClass(){
        Browser.close();
    }


}
