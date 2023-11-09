package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;
import pages.AlertsFrameWindowsPages.FramesPage;
import pages.AlertsFrameWindowsPages.NestedFramesPage;
import pages.BookStore.BookStorePage;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import pages.Elements.*;
import pages.Forms.PracticeFormPage;
import pages.Interaction.DroppablePage;
import pages.WidgetsPage.MenuPage;

public class SideMenu extends PageBase {
    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        wait(500);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    WebElement alertsPageLink;

    public AlertsPage openAlertsPage() {
        clickWithJSExecutor(alertsPageLink, 0, 200);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")
    WebElement profilePageLink;

    public ProfilePage openProfilePage() {
        clickWithJSExecutor(profilePageLink, 0, 300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStorePageLink;

    public BookStorePage openBookStorePage() {
        wait(1000);
        clickWithJSExecutor(bookStorePageLink, 0, 500);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsLink;

    public BrowserWindowsPage openBrowserWindowsPage() {
        click(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement framesPage;

    public FramesPage openFramesPage() {
        clickWithJSExecutor(framesPage, 0, 250);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFramesPage;

    public NestedFramesPage openNestedFramesPage() {
        clickWithJSExecutor(nestedFramesPage, 0, 250);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuPageLink;

    /*public SelectMenuPage openSelectMenu() {
        clickWithJSExecutor(selectMenuPageLink, 0, 400);
        wait(1000);
        return new SelectMenuPage(driver);
    }

     */

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBoxPageLink;

    public TextBoxPage openTextBox() {
        click(textBoxPageLink);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsPageLink;

    public ButtonsPage openButtons() {
        clickWithJSExecutor(buttonsPageLink, 0, 200);
        wait(1000);
        return new ButtonsPage(driver);
    }


    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownloadPageLink;

    public UploadAndDownloadPage openUploadAndDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink, 0, 300);
        return new UploadAndDownloadPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImagesLink;

    public BrokenLinksImagesPage openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 250);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppableLink;

    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 350);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menuPageLink;

    public MenuPage openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonLink;

    public RadioButtonPage openRadioButtonPage() {
        clickWithJSExecutor(radioButtonLink, 0, 350);
        return new RadioButtonPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormLink;

    public PracticeFormPage openPracticeFormPage() {
        clickWithJSExecutor(practiceFormLink, 0, 350);
        return new PracticeFormPage(driver);
    }
}
