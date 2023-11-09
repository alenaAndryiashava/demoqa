package selenium_tests.AlertsFrameWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.FramesPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class FramesTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openFramesPage();
    }

    @Test(enabled = false)
    public void ensureNumberOfFrames() {
        Assert.assertEquals(new FramesPage(driver)
                .getFramesNumber(), 2);
    }

    @Test
    public void switchToFrameById() {
        Assert.assertTrue(new FramesPage(driver)
                .switchToFrameById().getH1().contains("sample"));
    }
}
