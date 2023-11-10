package pages.AlertsFrameWindowsPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

import java.time.Duration;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;
    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    @FindBy(id = "confirmResult")
    private WebElement confirmText;
    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement promtButton;
    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptResult;

    public void clickOnSimpleAlert() {
        click(alertButton);
        wait(1000);
        driver.switchTo().alert().accept();
    }

    public void clickOnSimpleAlertWithTimer() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();
    }

    public String getConfirmText() {
        return confirmText.getText();
    }

    public AlertsPage clickOnConfirmBox(String action) {
        click(confirmButton);
        wait(1000);
        if (action.equals("OK")) {
            driver.switchTo().alert().accept();
        }
        if (action.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    public void clickToPromtButton() {
        promtButton.click();
    }

    public AlertsPage enterTextToPrompt(String name) {
        clickWithJSExecutor(promtButton, 0, 200);
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        return this;
    }

    public void clickToTimerAlertButton() {
        timerAlertButton.click();
    }

    public String waitAlertAndClickToOk() {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertText;
    }

    public void fillAlertInput(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getResultText() {
        return promptResult.getText();
    }
}
