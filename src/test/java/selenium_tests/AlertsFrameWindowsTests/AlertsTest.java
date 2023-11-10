package selenium_tests.AlertsFrameWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class AlertsTest extends TestBase {
    private final String text = faker.lorem().sentence(3);
    private final String expectedText = "You entered " + text;

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
                .getResultText().contains(name));
    }

    @Test
    public void acceptAndTextAlertTest() {
        AlertsPage alertPage = new AlertsPage(driver);
        alertPage.clickToTimerAlertButton();
        String actualAlertText = alertPage.waitAlertAndClickToOk();
        String expectedAlertText = "This alert appeared after 5 seconds";
        Assert.assertEquals(actualAlertText, expectedAlertText);
    }

    @Test
    public void getResultText() {
        AlertsPage alertPage = new AlertsPage(driver);
        alertPage.clickToPromtButton();
        alertPage.fillAlertInput(text);
        String actualText = alertPage.getResultText();
        Assert.assertEquals(actualText, expectedText);
    }
}
