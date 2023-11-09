package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.List;

public class FramesPage extends PageBase {
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "iframe")
    List<WebElement> iframes;
    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public int getFramesNumber() {
        //return iframes.size();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return Integer.parseInt(js.executeScript("return window.length").toString());
    }
    public FramesPage switchToFrameById() {
        driver.switchTo().frame(frame1);
        return this;
    }
    public String getH1() {
        return sampleHeading.getText();
    }
}
