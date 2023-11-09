package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.io.File;
import java.io.IOException;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "downloadButton")
    WebElement downloadButton;
    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public boolean verifyDownloaded() {
        // Clicked -> files is download -> check file exists
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/sampleFile.jpeg";
        File f = new File(path);

        if (f.exists()) {
            f.delete();
        }
        click(downloadButton);
        wait(4000);

        if (f.exists()) {
            f.delete();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public UploadAndDownloadPage selectFile() throws IOException {
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/sampleFile.jpeg";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("File already existed");
        }
        uploadFile.sendKeys(path);
        return this;
    }

    public boolean checkFileIsSelected() {
        return uploadedFilePath.isDisplayed();
    }
}
