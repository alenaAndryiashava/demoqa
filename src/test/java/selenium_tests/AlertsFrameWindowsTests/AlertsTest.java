package selenium_tests.AlertsFrameWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class AlertsTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openAlertsPage();
    }

    @Test
    public void invokeAlert() {
        new AlertsPage(driver).clickOnSimpleAlert();
    }

    @Test
    public void simpleAlert5Secs() {
        new AlertsPage(driver).clickOnSimpleAlertWithTimer();
    }

    @Test
    public void confirmBoxTest() {
        Assert.assertTrue(new AlertsPage(driver)
                .clickOnConfirmBox("OK").getConfirmText().contains("Ok"));
        Assert.assertTrue(new AlertsPage(driver)
                .clickOnConfirmBox("Cancel")
                .getConfirmText().contains("Cancel"));
    }

    @Test
    public void enterTextToPromptTest() {
        String name = "Alena";
        Assert.assertTrue(new AlertsPage(driver)
                .enterTextToPrompt(name)
                .getPromptResult().contains(name));
    }
}
