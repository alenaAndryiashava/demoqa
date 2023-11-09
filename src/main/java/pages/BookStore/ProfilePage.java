package pages.BookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement logOutButton;
    @FindBy(id = "userName-value")
    WebElement userNameValue;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span")
    WebElement firstBookTitle;
    @FindBy(id = "delete-record-undefined")
    WebElement deleteButton;
    @FindBy(id = "closeSmallModal-ok")
    WebElement closeSmallButton;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/button")
    WebElement logoutProfileButton;

    public LoginPage logout() {
        click(logOutButton);
        return new LoginPage(driver);
    }

    public String getUserNameValue() {
        return userNameValue.getText();
    }

    public String getFirstBookTitle() {
        return firstBookTitle.getText();
    }

    public ProfilePage deleteBook() {
        click(deleteButton);
        wait(1000);
        click(closeSmallButton);
        wait(2000);
        driver.switchTo().alert().accept();
        return this;
    }

    public LoginPage logOut() {
        click(logoutProfileButton);
        return new LoginPage(driver);
    }
}
