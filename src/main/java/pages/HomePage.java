package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.BookStore.BookStorePage;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[3]")
    WebElement alertsFrameWindowsLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]")
    WebElement widgetsLink;
    @FindBy(xpath = " //body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement textBoxLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[5]")
    WebElement interactionsPageLink;
    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement formsLink;

    public void openBookStoreApp() {
        clickWithJSExecutor(bookStoreAppLink, 0, 300);
        new BookStorePage(driver);
    }

    public void openAlertsFrameWindowsPage() {
        click(alertsFrameWindowsLink);
        new AlertsPage(driver);
    }

    public void openWidgetsPage() {
        click(widgetsLink);
        new SideMenu(driver);
    }

    public void openElements() {
        click(textBoxLink);
        new SideMenu(driver);
    }

    public void openInteractions() {
        click(interactionsPageLink);
        new SideMenu(driver);
    }

    public void openForms() {
        click(formsLink);
        new SideMenu(driver);
    }
}
