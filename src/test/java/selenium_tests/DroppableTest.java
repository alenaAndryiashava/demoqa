package selenium_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Interaction.DroppablePage;
import pages.SideMenu;

public class DroppableTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openIntercations();
        new SideMenu(driver).openDroppablePage();
    }

    @Test
    public void dragHereTest() {
        Assert.assertTrue(new DroppablePage(driver)
                .testDroppableHere()
                .getDroppedResult().contains("Dropped!"));
    }

    @Test
    public void dragByOffsetElement() {
        Assert.assertTrue(new DroppablePage(driver)
                .testDroppableByOffset()
                .getDroppedResult().contains("Dropped!"));
    }
}
