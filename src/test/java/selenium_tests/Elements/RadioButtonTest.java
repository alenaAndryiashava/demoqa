package selenium_tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.RadioButtonPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class RadioButtonTest extends TestBase {
    // Pre-conditions: Buttons page is opened
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openRadioButtonPage();
    }
    @Test
    public void selectRadioButtons(){
        Assert.assertTrue(new RadioButtonPage(driver)
                .selectYes()
                .checkSelected().contains("Yes"));
    }
}
