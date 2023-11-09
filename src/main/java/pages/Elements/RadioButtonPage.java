package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class RadioButtonPage extends PageBase {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[.='Yes']")
    WebElement labelYes;
    @FindBy(xpath = "//span[@class='text-success']")
    WebElement textSuccess;

    public RadioButtonPage selectYes() {
        hideAds();
        labelYes.click();
        return this;
    }

    public String checkSelected() {
        return textSuccess.getText();
    }
}
