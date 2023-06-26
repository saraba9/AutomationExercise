package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import general.Browser;

public class HtmlTablesPage {

    private By customersTable = By.cssSelector("table[id='customers']");

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        try {
            String curText = getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
            System.out.println(curText);
            Assert.assertEquals(curText, expectedText);
            return true;
        } catch (Exception e) {
            return false;
        } catch (AssertionError ae) {
            return false;
        }
    }

    public String getTableCellTextByXpath (WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception{
        try {
            return table.findElement(By.xpath(".//tr[.//td["+searchColumn+"][text()='"+searchText+"']]/td["+returnColumnText+"]")).getText();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    public WebElement getCustomerTable  () {
       return Browser.driver().findElement(customersTable);
    }
}
