package selenium_tests.Elements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.DynamicPropertiesPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class DynamicPropertiesTests extends TestBase {
    private DynamicPropertiesPage dynamicProperties;

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openDynamicPropertiesPage();
    }

    @Test
    public void waitButton() {
        dynamicProperties = new DynamicPropertiesPage(driver);
        dynamicProperties.waitButton();
    }

    @Test
    public void colorButton() {
        dynamicProperties = new DynamicPropertiesPage(driver);
        dynamicProperties.waitButton();
        String color = dynamicProperties.getCss();
        System.out.println(color);
    }
}
