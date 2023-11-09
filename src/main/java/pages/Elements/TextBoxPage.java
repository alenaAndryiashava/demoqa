package pages.Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.Data.TextBoxData;
import pages.PageBase;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submit;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[1]")
    WebElement output;

    public void fillAndSubmitForm() throws IOException, UnsupportedFlavorException {
        hideAds();

        type(fullName, TextBoxData.FULLNAME);
        type(email, TextBoxData.EMAIL);
        type(currentAddress, TextBoxData.ADDRESS);

        Actions action = new Actions(driver);

        Keys cmdCtrl = getCmdCtrl();


        action.keyDown(currentAddress, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        String result = (String) contents.getTransferData(DataFlavor.stringFlavor);
        if (result.equals(TextBoxData.ADDRESS)) {

            action.sendKeys(Keys.TAB);
            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
        }
        clickWithJSExecutor(submit, 0, 150);
    }

    public String checkSubmittedData() {
        return output.getText();
    }

    public String getPermanentAddress() {
        System.out.println("Permanent address is " + permanentAddress.getText());
        return permanentAddress.getText();
    }
}
