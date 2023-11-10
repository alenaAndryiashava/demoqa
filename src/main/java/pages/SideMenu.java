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
import pages.WidgetsPage.SelectMenuPage;

public class SideMenu extends PageBase {
    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    WebElement alertsPageLink;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")
    WebElement profilePageLink;
    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStorePageLink;
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsLink;
    @FindBy(xpath = "//span[.='Frames']")
    WebElement framesPage;
    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFramesPage;
    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuPageLink;
    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBoxPageLink;
    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsPageLink;
    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownloadPageLink;
    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImagesLink;
    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppableLink;
    @FindBy(xpath = "//span[.='Menu']")
    WebElement menuPageLink;
    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonLink;
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormLink;

    public void openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        wait(500);
        new LoginPage(driver);
    }

    public void openAlertsPage() {
        clickWithJSExecutor(alertsPageLink, 0, 200);
        new AlertsPage(driver);
    }

    public void openProfilePage() {
        clickWithJSExecutor(profilePageLink, 0, 300);
        new ProfilePage(driver);
    }

    public void openBookStorePage() {
        wait(1000);
        clickWithJSExecutor(bookStorePageLink, 0, 500);
        new BookStorePage(driver);
    }

    public BrowserWindowsPage openBrowserWindowsPage() {
        click(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    public void openFramesPage() {
        clickWithJSExecutor(framesPage, 0, 250);
        new FramesPage(driver);
    }

    public void openNestedFramesPage() {
        clickWithJSExecutor(nestedFramesPage, 0, 250);
        new NestedFramesPage(driver);
    }

    public void openSelectMenu() {
        clickWithJSExecutor(selectMenuPageLink, 0, 400);
        wait(1000);
        new SelectMenuPage(driver);
    }

    public void openTextBox() {
        click(textBoxPageLink);
        new TextBoxPage(driver);
    }

    public void openButtons() {
        clickWithJSExecutor(buttonsPageLink, 0, 200);
        wait(1000);
        new ButtonsPage(driver);
    }

    public void openUploadAndDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink, 0, 300);
        new UploadAndDownloadPage(driver);
    }

    public void openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 250);
        new BrokenLinksImagesPage(driver);
    }

    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 350);
        return new DroppablePage(driver);
    }

    public void openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
        new MenuPage(driver);
    }

    public void openRadioButtonPage() {
        clickWithJSExecutor(radioButtonLink, 0, 350);
        new RadioButtonPage(driver);
    }

    public PracticeFormPage openPracticeFormPage() {
        clickWithJSExecutor(practiceFormLink, 0, 350);
        return new PracticeFormPage(driver);
    }
}
