package selenium_tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.WidgetsPage.SelectMenuPage;
import selenium_tests.TestBase;

public class SelectMenuTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openWidgetsPage();
        new SideMenu(driver).openSelectMenu();
    }
    // Preconditions:
    // 1. Open Home Page
    // 2. Open Widgets
    // 3. Open Select menu

    @Test
    public void fillInTwoSelectFields() {
        Assert.assertTrue(new SelectMenuPage(driver)
                .choseFromSelectValue()
                .getSelectValueText().contains("Group 1"));
        Assert.assertTrue(new SelectMenuPage(driver)
                .choseFromSelectOne().getSelectOneText().contains("Prof."));
    }
    // Title: The value of old style select is Yellow if we chose Yellow

    @Test
    public void oldStyleSelectMenu() {
        SelectMenuPage ourPage = new SelectMenuPage(driver);
        // Step 1: Click on dropdown menu (old style select menu)
        // Step 2: Chose Yellow by clicking on this value in the list
        ourPage.choseYellowFromOldStyleSelect();
        // Expected result: Yellow is selected in the old style select
        String ourText = ourPage.getOldStyleSelectValueText();
        Assert.assertTrue(ourText.contains("Yellow"));
        //Assert.assertTrue( new SelectMenuPage(driver).choseFromOldStyleSelect().getOldStyleSelectValue().contains("Yellow") );
    }
    //Write test to select Volvo and Opel from “Standard multi select” select menu

    @Test
    public void selectCarFromStandardMultiSelect() {
        SelectMenuPage ourPage = new SelectMenuPage(driver);
        // Step 1: Click on dropdown menu (Standard multi select)
        // Step 2: Chose Volvo by clicking on this value in the list

        ourPage.choseCarFromStandardMultiSelect("Volvo");
        String car = ourPage.getCarText();

        Assert.assertTrue(car.contains("Volvo"));
        // Expected result: Volvo is selected in the Standard multi select
        // Step 2: Chose Opel by clicking on this value in the list

        ourPage.choseCarFromStandardMultiSelect("Opel");
        sleep(5000);
        Assert.assertTrue(car.contains("Opel"));
        // Expected result:Opel is selected in the Standard multi select
    }
}
