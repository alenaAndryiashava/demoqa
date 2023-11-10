package selenium_tests.AlertsFrameWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class BrowserWindowsTests extends TestBase {
    BrowserWindowsPage browserWindowsPage;
    String originalWindow;

    String messageText = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openBrowserWindowsPage();
    }
    @Test
    public void newTabTest() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();
        browserWindowsPage.clickToNewTabButton();
        browserWindowsPage.switchToNewTab(originalWindow);
        Assert.assertTrue(browserWindowsPage.isNewTabHeaderVisible());
        browserWindowsPage.closeAndSwitchToOriginalWindow(originalWindow);
        Assert.assertTrue(browserWindowsPage.shouldBeVisible());
    }

    @Test
    public void newWindowTest() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();
        browserWindowsPage.clickToNewWindowButton();
        browserWindowsPage.switchToNewTab(originalWindow);
        Assert.assertTrue(browserWindowsPage.isNewTabHeaderVisible());
        browserWindowsPage.closeAndSwitchToOriginalWindow(originalWindow);
        Assert.assertTrue(browserWindowsPage.shouldBeVisible());
    }

    @Test
    public void newMessageWindowTest() {
        browserWindowsPage = new BrowserWindowsPage(driver);
        originalWindow = browserWindowsPage.getOriginalWindow();
        browserWindowsPage.clickToNewMessageWindowButton();
        browserWindowsPage.switchToNewTab(originalWindow);
        String text = browserWindowsPage.getMessageText();
        Assert.assertEquals(text, messageText);
        browserWindowsPage.closeAndSwitchToOriginalWindow(originalWindow);
        Assert.assertTrue(browserWindowsPage.shouldBeVisible());
    }
    //TODO этот тест зависает, нужно разобраться почему
    // test passed only with Firefox browser!!
}
