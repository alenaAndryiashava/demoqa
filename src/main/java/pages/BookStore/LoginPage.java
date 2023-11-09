package pages.BookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "name")
    public WebElement errorMsg;
    @FindBy(id = "submit")
    public WebElement logOutButton;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/h5")
    WebElement welcomeMessage;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage login(String uName, String uPass) {
        type(username, uName);
        type(password, uPass);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public LoginPage logOut() {
        click(logOutButton);
        return this;
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
