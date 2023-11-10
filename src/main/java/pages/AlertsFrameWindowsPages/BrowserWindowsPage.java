package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTabButton;
    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement mainHeader;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButton;
    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement newMessageWindowButton;
    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement newTabHeader;
    @FindBy(xpath = "//body")
    private WebElement newMessageText;

    public BrowserWindowsPage openNewTab() {
        click(newTabButton);
        //String thisWindow = driver.getWindowHandle();
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    public String getNewTabHeader() {
        return newTabHeader.getText();
    }
    public boolean isNewTabHeaderVisible() {
        return newTabHeader.isDisplayed();
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

    public void clickToNewTabButton() {
        newTabButton.click();
    }

    public void clickToNewWindowButton() {
        newWindowButton.click();
    }

    public void clickToNewMessageWindowButton() {
        newMessageWindowButton.click();
    }

    public boolean shouldBeVisible() {
        return mainHeader.isDisplayed();
    }
    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public void switchToNewTab(String originalWindow) {
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            if(!originalWindow.equals(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void closeAndSwitchToOriginalWindow(String originalWindow) {
        driver.close();
        driver.switchTo().window(originalWindow);
    }
}
