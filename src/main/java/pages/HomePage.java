package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.BookStore.BookStorePage;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;



    public BookStorePage openBookStoreApp(){
        clickWithJSExecutor(bookStoreAppLink,0,300);

        return new BookStorePage(driver);

    }
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]")
    WebElement alertsFrameWindowsLink;

    public AlertsPage openAlertsFrameWindowsPage() {
        click(alertsFrameWindowsLink);
        return new AlertsPage(driver);

    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]")
    WebElement widgetsLink;
    public SideMenu openWidgetsPage() {
        click(widgetsLink);
        return new SideMenu(driver);
    }

    @FindBy(xpath = " //body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement textBoxLink;

    public SideMenu openElements() {
        click(textBoxLink);
        return new SideMenu(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]")
    WebElement interactionsPageLink;

    public SideMenu openIntercations() {
        click(interactionsPageLink);
        return new SideMenu(driver);
    }
    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement formsLink;
    public SideMenu openForms() {
        click(formsLink);
        return new SideMenu(driver);
    }
}
