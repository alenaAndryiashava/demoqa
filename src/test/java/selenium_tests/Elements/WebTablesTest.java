package selenium_tests.Elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.WebTablesPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

import java.util.List;
import java.util.Map;

public class WebTablesTest extends TestBase {
    WebTablesPage tablePage;
    List<Map<String, String>> rows;

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openWebTables();
    }

    @Test
    public void tableTest() {
        tablePage = new WebTablesPage(driver);
        rows = tablePage.getTableData();
        String email = rows.get(2).get("Email");
        System.out.println(email + "123456");
    }
}
