package pages.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmailInput;
    @FindBy(xpath = "//label[.='Male']")
    WebElement labelMale;

    @FindBy(xpath = "//label[.='Female']")
    WebElement labelFemale;

    @FindBy(xpath = "//label[.='Other']")
    WebElement labelOther;
    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement userNumberInput;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']']")
    WebElement dateOfBirthInput;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement subjectsInput;
    @FindBy(xpath = "//label[.='Reading']")
    WebElement labelReading;

    @FindBy(xpath = "//label[.='Music']")
    WebElement labelMusic;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[7]/div[2]")
    WebElement hobbies;
    @FindBy(xpath = "//label[.='Sports']")
    WebElement labelSports;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement studentNameField;
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    public WebElement studentEmailField;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    public WebElement genderField;
    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    public WebElement mobileField;
    @FindBy(xpath = "//tbody/tr[7]/td[2]")
    public WebElement hobbiesField;

    @FindBy(xpath = "//tbody/tr[9]/td[2]")
    public WebElement addressField;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
    WebElement closeLargeModal;

    public WebElement getSubjectsInput() {
        return subjectsInput;
    }

    public void setSubjectsInput(WebElement subjectsInput) {
        this.subjectsInput = subjectsInput;
    }

    public String checkName() {
        return studentNameField.getText();
    }

    public String checkEmail() {
        return studentEmailField.getText();
    }

    public String checkMobile() {
        return mobileField.getText();
    }

    public String checkAddress() {
        return addressField.getText();
    }

    public WebElement getCloseLargeModal() {
        return closeLargeModal;
    }

    public PracticeFormPage selectGender(WebElement gender) {
        hideAds();
        gender.click();
        return this;
    }

    public PracticeFormPage selectHobbies(WebElement hobbies) {

        hobbies.click();
        return this;
    }

    public String getSubject() {
        return subjectsInput.getText();
    }

    public PracticeFormPage choseSubjects() {
        click(subjectsInput);
        wait(1000);
        return this;
    }

    public void fillData(String firstName, String lastName, String email, String mobile, String address) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
        selectGender(labelMale);
        wait(1000);
        userNumberInput.clear();
        userNumberInput.sendKeys(mobile);
        wait(1000);
        subjectsInput.clear();

        selectHobbies(labelSports);
        selectHobbies(labelReading);
        wait(1000);
        type(currentAddress, address);
        submitButton.click();
        //closeLargeModal.click();
    }
}
