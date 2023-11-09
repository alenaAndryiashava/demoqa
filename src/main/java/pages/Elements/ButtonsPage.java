package pages.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ButtonsPage extends PageBase {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage doubleClick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        return this;
    }

    public String getDCMsg() {
        return doubleClickMessage.getText();
    }

    public ButtonsPage rightClick() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
        return this;
    }


    public String getRCMsg() {
        return rightClickMessage.getText();
    }
}


