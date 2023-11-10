package selenium_tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Forms.PracticeFormPage;
import pages.HomePage;
import pages.SideMenu;

import java.util.Map;

public class PracticeFormTest extends TestBase {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String text = faker.lorem().sentence(5);
    String address = faker.address().fullAddress();
    Map<String, String> contactInfo;

    // Pre-conditions: practice form is opened
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openForms();
        new SideMenu(driver).openPracticeFormPage();
    }

    /*
    Task:
1. Create positive test(s) to fill in required fields,
to submit the form, and to check submitted data
2. Create negative test(s) to verify that fields
must not be empty or contain data in required format
3. Select date with calendar date picker
     */
    @Test
    public void practiceFormWithCorrectDataTest() {
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillData(firstName, lastName, email, mobile, address);
        Assert.assertEquals(practiceFormPage.checkName(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormPage.checkEmail(), email);
        Assert.assertEquals(practiceFormPage.checkMobile(), mobile);
        Assert.assertEquals(practiceFormPage.checkAddress(), address);
        practiceFormPage.getCloseLargeModal().click();
    }
}
