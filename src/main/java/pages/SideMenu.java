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

    @FindBy(xpath = "//span[.='Login']")
    private WebElement loginPageLink;
    @FindBy(xpath = "//span[.='Alerts']")
    private WebElement alertsPageLink;
    @FindBy(xpath = "//span[.='Profile']")
    private WebElement profilePageLink;
    @FindBy(xpath = "//span[.='Book Store']")
    private WebElement bookStorePageLink;
    @FindBy(xpath = "//span[.='Browser Windows']")
    private WebElement browserWindowsLink;
    @FindBy(xpath = "//span[.='Frames']")
    private WebElement framesPage;
    @FindBy(xpath = "//span[.='Nested Frames']")
    private WebElement nestedFramesPage;
    @FindBy(xpath = "//span[.='Select Menu']")
    private WebElement selectMenuPageLink;
    @FindBy(xpath = "//span[.='Text Box']")
    private WebElement textBoxPageLink;
    @FindBy(xpath = "//span[.='Buttons']")
    private WebElement buttonsPageLink;
    @FindBy(xpath = "//span[.='Upload and Download']")
    private WebElement uploadAndDownloadPageLink;
    @FindBy(xpath = "//span[.='Broken Links - Images']")
    private WebElement brokenLinksImagesLink;
    @FindBy(xpath = "//span[.='Dynamic Properties']")
    private WebElement dynamicPropertiesLink;
    @FindBy(xpath = "//span[.='Droppable']")
    private WebElement droppableLink;
    @FindBy(xpath = "//span[.='Menu']")
    private WebElement menuPageLink;
    @FindBy(xpath = "//span[.='Radio Button']")
    private WebElement radioButtonLink;
    @FindBy(xpath = "//span[.='Date Picker']")
    private WebElement datePickerLink;
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

    public void openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 250);
        new BrokenLinksImagesPage(driver);
    }

    public void openUploadAndDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink, 0, 300);
        new UploadAndDownloadPage(driver);
    }

    public void openDynamicPropertiesPage() {
        clickWithJSExecutor(dynamicPropertiesLink, 0, 300);
        new DynamicPropertiesPage(driver);
    }

    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 350);
        return new DroppablePage(driver);
    }

    public void openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
        new MenuPage(driver);
    }

    public void openDatePicker() {
        clickWithJSExecutor(datePickerLink, 0, 350);
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
