package selenium_tests.BookStoreTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import pages.Data.LoginData;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class BookStoreLoginTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openBookStoreApp();
        new SideMenu(driver).openLoginPage();
    }

    @Test
    public void positiveAuthTest() {
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        Assert.assertEquals(new ProfilePage(driver).getUserNameValue(), LoginData.USERNAME);
    }

    @Test
    public void negativeAuthTest() {
        new LoginPage(driver).login("Mallory", "1233654");
        String error = "Invalid username or password";
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains(error));
    }

    @Test
    public void logOutTest() {
        new LoginPage(driver).login("MalloryWarner", "Qwerty123!1");
        new SideMenu(driver).openLoginPage();
        new LoginPage(driver).logOut();
        Assert.assertTrue(new LoginPage(driver).getWelcomeMessage().contains("Login in Book Store"));
    }
}
