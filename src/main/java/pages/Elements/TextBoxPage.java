package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Data.TextBoxData;
import pages.PageBase;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailInput;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddressInput;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddressInput;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id='output']//div")
    private WebElement infoField;

    public void fillAndSubmitForm() throws IOException, UnsupportedFlavorException {
        hideAds();

        type(nameInput, TextBoxData.FULLNAME);
        type(emailInput, TextBoxData.EMAIL);
        type(currentAddressInput, TextBoxData.ADDRESS);

        Actions action = new Actions(driver);

        Keys cmdCtrl = getCmdCtrl();


        action.keyDown(currentAddressInput, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        String result = (String) contents.getTransferData(DataFlavor.stringFlavor);
        if (result.equals(TextBoxData.ADDRESS)) {

            action.sendKeys(Keys.TAB);
            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
        }
        clickWithJSExecutor(saveButton, 0, 150);
    }

    public String checkSubmittedData() {
        return infoField.getText();
    }

    public String getPermanentAddress() {
        System.out.println("Permanent address is " + permanentAddressInput.getText());
        return permanentAddressInput.getText();
    }

    public void fillTextBox(String name, String email, String currentAddress, String permanentAddress) {
        nameInput.clear();
        nameInput.sendKeys(name);
        emailInput.clear();
        emailInput.sendKeys(email);
        currentAddressInput.clear();
        currentAddressInput.sendKeys(currentAddress);
        permanentAddressInput.clear();
        permanentAddressInput.sendKeys(permanentAddress);
        saveButton.click();
    }

    public String getName() {
        return driver
                .findElement(By.xpath("//p[@id=\"name\"]"))
                .getText();
    }

    public String getTextFromInfoField(String idName) {
        return driver
                .findElement(By.xpath(String.format("//p[@id='%s']", idName)))
                .getText();
    }

    public void waitText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(infoField, "Name"));
    }
}
