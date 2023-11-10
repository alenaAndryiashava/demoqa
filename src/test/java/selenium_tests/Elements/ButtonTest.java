package selenium_tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.ButtonsPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class ButtonTest extends TestBase {
    // Pre-conditions: Buttons page is opened
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openButtons();
    }

    // Title: Check message after double-click on <Double click Me> button.
    @Test
    public void clickOnDoubleClickButton() {
        // Step1: Double-click on <Double Click Me> button
        // Expected result: <You have done a double click> message is displayed.
        Assert.assertTrue(new ButtonsPage(driver)
                .doubleClick()
                .getDCMsg()
                .contains("double"));
    }

    // Title: Check message after right-click on <Right Click Me> button
    @Test
    public void clickOnRightClickButton() {
        // Step1: Right click on <Right Click Me> button
        // Expected result: <You have done a right click> message is displayed
        Assert.assertTrue(new ButtonsPage(driver)
                .rightClick()
                .getRCMsg().contains("right"));
    }
}
