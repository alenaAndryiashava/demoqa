package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

import java.time.Duration;

public class DynamicPropertiesPage extends PageBase {
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement waitedButton;
    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement colorChangeButton;

    public void waitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(waitedButton));
    }

    public String getCss() {
        return colorChangeButton.getCssValue("color");
    }
}
