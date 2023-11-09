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
    WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    WebElement confirmButton;
    @FindBy(id = "confirmResult")
    WebElement confirmText;
    @FindBy(id = "promtButton")
    WebElement promtButton;
    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage clickOnSimpleAlert() {
        click(alertButton);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage clickOnSimpleAlertWithTimer() {
        click(timerAlertButton);

        // wait(5500);
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();
        return this;
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
    public AlertsPage enterTextToPrompt(String name) {
        clickWithJSExecutor(promtButton, 0, 200);
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
        return this;
    }
    public String getPromptResult() {
        return promptResult.getText();
    }
}
