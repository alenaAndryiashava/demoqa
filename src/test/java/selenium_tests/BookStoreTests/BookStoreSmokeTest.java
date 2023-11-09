package selenium_tests.BookStoreTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookStore.BookStorePage;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import pages.Data.LoginData;
import pages.HomePage;
import pages.SideMenu;
import selenium_tests.TestBase;

public class BookStoreSmokeTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
        new SideMenu(driver).openLoginPage();
    }
    @Test
    public void bookStoreSmokeTest(){
        String title = "Web";
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        new SideMenu(driver).openBookStorePage();
        new BookStorePage(driver).searchBook(title).openFirstBook().addToYourCollection();
        new SideMenu(driver).openProfilePage();
        Assert.assertTrue( new ProfilePage(driver).getFirstBookTitle().contains(title));
    }

    @AfterMethod
    public void deleteBookAndLogOut() {
        new ProfilePage(driver).deleteBook().logOut();

    }
}
