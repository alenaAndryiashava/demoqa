package selenium_tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.ProgressBarPage;
import selenium_tests.TestBase;

public class ProgressBarTests extends TestBase {
    private final String percent = Integer.toString(faker.number().numberBetween(10, 99));

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openWidgetsPage();
        new SideMenu(driver).openProgressBarPage();
    }

    @Test
    public void progressBarTest() {
        ProgressBarPage progressBar = new ProgressBarPage(driver);
        progressBar.clickToButton();
        progressBar.clickToStop(percent);
        String actualPercent = progressBar.getPercent();
        Assert.assertEquals(actualPercent, percent + "%");
        System.out.println(percent);
    }
}
