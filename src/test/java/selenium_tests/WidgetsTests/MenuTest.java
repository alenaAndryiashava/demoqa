package selenium_tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.MenuPage;
import selenium_tests.TestBase;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openWidgetsPage();
        new SideMenu(driver).openMenu();
    }
    // Preconditions:
    // 1. Open Home Page
    // 2. Open Widgets
    // 3. Open Select menu

    @Test
    public void checkSubSubMenu() {
        Assert.assertTrue(new MenuPage(driver)
                .openSubSubMenu()
                .getSubSubItemText().contains("Item 1"));
    }
}
