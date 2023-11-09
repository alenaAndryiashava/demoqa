package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "tabButton")
    WebElement newTabButton;
    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    WebElement newMessageWindowButton;
    @FindBy(id = "sampleHeading")
    WebElement newPageHeading;
    @FindBy(xpath = "/html/body")
    WebElement newMessageText;

    public BrowserWindowsPage openNewTab() {
        click(newTabButton);
        //String thisWindow = driver.getWindowHandle();
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    public String getNewPageHeading() {
        return newPageHeading.getText();
    }

    public BrowserWindowsPage openNewWindow() {
        click(newWindowButton);
        String thisWindow = driver.getWindowHandle();
        for (String windowH : driver.getWindowHandles()) {
            if (!thisWindow.contentEquals(windowH)) {
                System.out.println(windowH);
                driver.switchTo().window(windowH);
                break;
            }
        }
        return this;
    }

    public BrowserWindowsPage openNewWindowMessage() {
        click(newMessageWindowButton);
        wait(1000);
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    public String getMessageText() {
        return newMessageText.getText();
    }

    public BrowserWindowsPage closeWindow() {
        driver.close();
        return this;
    }
}
