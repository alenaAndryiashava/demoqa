package selenium_tests.AlertsFrameWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.NestedFramesPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class NestedFramesTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openNestedFramesPage();
    }

    @Test
    public void verifyTextInParentChildFrames() {
        Assert.assertTrue(new NestedFramesPage(driver)
                .getParentFrameText()
                .contains("Parent"));
        Assert.assertTrue(new NestedFramesPage(driver)
                .getChildFrameText()
                .contains("Child"));
    }
}
