package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class NestedFramesPage extends PageBase {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(xpath = "/html/body")
    WebElement bodyFrame1;
    @FindBy(xpath="/html/body/p")
    WebElement paragraph;
    public String getParentFrameText() {
        driver.switchTo().frame(frame1);
        String body = bodyFrame1.getText();
        driver.switchTo().defaultContent();
        return body;
    }
    public String getChildFrameText() {
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(0);
        String p = paragraph.getText();
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        return p;
    }
}
