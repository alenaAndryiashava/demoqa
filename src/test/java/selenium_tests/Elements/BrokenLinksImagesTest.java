package selenium_tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.BrokenLinksImagesPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

import java.io.IOException;

public class BrokenLinksImagesTest extends TestBase {
    // Pre-conditions: Buttons page is opened
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openBrokenLinksImages();
    }

    // Title: Check page for broken images (not displayed, not-existent source)
    @Test
    public void checkBrokenImages() {

        Assert.assertEquals(new BrokenLinksImagesPage(driver)
                .checkNumberBrokenImages(), 0);
    }

    // Title: Check page for broken links (status code of the target link is >= 400)
    @Test
    public void checkBrokenLinks() throws IOException {

        Assert.assertEquals(new BrokenLinksImagesPage(driver)
                .checkNumberBrokenLinks(), 0);
    }
}
