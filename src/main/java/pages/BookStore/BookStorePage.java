package pages.BookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="searchBox")
    WebElement searchBox;


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
    WebElement firstBook;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")
    WebElement addNewRecordButton;
    //@FindBy(id="addNewRecordButton")

    public BookStorePage searchBook(String web) {
        type(searchBox, web);
        wait(500);
        return this;
    }
    public String getFirstBookTitle() {
        return firstBook.getText();
    }
    public BookStorePage openFirstBook() {
        click(firstBook);
        wait(1000);
        return this;
    }
    public BookStorePage addToYourCollection() {
        hideAds();
        wait(1000);
        clickWithJSExecutor(addNewRecordButton, 0, 300);
        wait(3000);
        driver.switchTo().alert().accept();
        return this;
    }
}
