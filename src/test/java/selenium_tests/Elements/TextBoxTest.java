package selenium_tests.Elements;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Data.TextBoxData;
import pages.Elements.TextBoxPage;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TextBoxTest extends TestBase {
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().fullAddress();
    // Pre-conditions: 1. Open Home Page 2. Open Elements 3. Open TextBox
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openTextBox();
    }

    // Title: Check that div with 'output' displays correct data from the form input fields
    @Test
    public void simpleFormSubmit() throws IOException, UnsupportedFlavorException {
        // Step 1: Fill in the full name input with John Doe value
        // Step 2: Fill in the email input with john@doe.com
        // Step 3: Fill in the current address with "10318, Germany, Berlin, Marksburgstrasse 1," data
        // Step 4: Copy value from the Current Address text area to Permanent Address textarea
        // Step 5: Submit the form
        // Expected results: All data from steps1-4 is presented in the output div.
        TextBoxPage ourPage = new TextBoxPage(driver);
        ourPage.fillAndSubmitForm();
        Assert.assertTrue(ourPage.checkSubmittedData().contains(TextBoxData.FULLNAME));
        Assert.assertTrue(ourPage.checkSubmittedData().contains(TextBoxData.ADDRESS));
        Assert.assertTrue(ourPage.checkSubmittedData().contains(TextBoxData.EMAIL));
        //Assert.assertEquals(ourPage.getPermanentAddress(), TextBoxData.ADDRESS);
    }
    @Test
    public void boxTest() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillTextBox(name,email, currentAddress, permanentAddress);
        textBoxPage.waitText();

//        Assert.assertEquals(textBox.getName(), "Name:" + name);

        Assert.assertEquals(textBoxPage.getTextFromInfoField("name"), "Name:" + name);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("email"), "Email:" + email);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("currentAddress"),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textBoxPage.getTextFromInfoField("permanentAddress"),
                "Permananet Address :" + permanentAddress);
    }
}
