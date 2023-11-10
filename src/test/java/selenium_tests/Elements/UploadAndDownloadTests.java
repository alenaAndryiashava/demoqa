package selenium_tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.UploadAndDownloadPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

import java.io.IOException;

public class UploadAndDownloadTests extends TestBase {
    // Pre-conditions: 1. Open Home Page 2. Open Elements 3. Open Upload and Download
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openUploadAndDownloadPage();
    }
    // Title: File is downloaded after Download button is clicked
    @Test
    public void clickOnDownloadButton(){
        // Step1: Click on Download button
        // Expected result: File is downloaded locally
        Assert.assertTrue( new UploadAndDownloadPage(driver)
                .verifyDownloaded() );
    }
    @Test
    public void selectFileToUpload() throws IOException {
        Assert.assertTrue( new UploadAndDownloadPage(driver)
                .selectFile().checkFileIsSelected() );
    }
}
