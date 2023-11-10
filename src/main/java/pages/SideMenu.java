package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;


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
    @FindBy(xpath = "//span[.='Web Tables']")
    private WebElement webTablesLink;
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
    @FindBy(xpath = "//span[.='Progress Bar']")
    private WebElement progressBarLink;
    @FindBy(xpath = "//span[.='Practice Form']")
    private WebElement practiceFormLink;

    public void openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
    }

    public void openAlertsPage() {
        clickWithJSExecutor(alertsPageLink, 0, 200);
    }

    public void openProfilePage() {
        clickWithJSExecutor(profilePageLink, 0, 300);
    }

    public void openBookStorePage() {
        clickWithJSExecutor(bookStorePageLink, 0, 500);
    }

    public BrowserWindowsPage openBrowserWindowsPage() {
        click(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    public void openFramesPage() {
        clickWithJSExecutor(framesPage, 0, 250);
    }

    public void openNestedFramesPage() {
        clickWithJSExecutor(nestedFramesPage, 0, 250);
    }

    public void openSelectMenu() {
        clickWithJSExecutor(selectMenuPageLink, 0, 400);
    }

    public void openTextBox() {
        textBoxPageLink.click();
    }

    public void openWebTables() {
        webTablesLink.click();
    }

    public void openButtons() {
        buttonsPageLink.click();
    }

    public void openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImagesLink, 0, 250);
    }

    public void openUploadAndDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink, 0, 300);
    }

    public void openDynamicPropertiesPage() {
        clickWithJSExecutor(dynamicPropertiesLink, 0, 300);
    }

    public void openDroppablePage() {
        clickWithJSExecutor(droppableLink, 0, 350);
    }

    public void openMenu() {
        clickWithJSExecutor(menuPageLink, 0, 350);
    }

    public void openDatePicker() {
        clickWithJSExecutor(datePickerLink, 0, 350);
    }

    public void openProgressBarPage() {
        progressBarLink.click();
    }

    public void openRadioButtonPage() {
        radioButtonLink.click();
    }

    public void openPracticeFormPage() {
        clickWithJSExecutor(practiceFormLink, 0, 350);
    }
}
