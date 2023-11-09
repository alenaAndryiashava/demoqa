package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJSExecutor(WebElement element, int x, int y) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        wait(500);
        click(element);
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideAds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('adplus-anchor').style.display='none'");
    }

    public void removeAds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('adplus-anchor').remove()");
    }
    //instead jsexecutor:
    //new Actions(dr).keyDown(Keys.PAGE_DOWN).perform();

    //alertsWindows

    public Keys getCmdCtrl() {
        Keys cmdCtrl = null;
        String os = System.getProperty("os.name");
        System.out.println(os);

        if (os.startsWith("Win")) {
            cmdCtrl = Keys.CONTROL;
            return cmdCtrl;
        } else if (os.startsWith("Mac")) {
            cmdCtrl = Keys.COMMAND;
            return cmdCtrl;
        }
        return null;
    }

    public int checkLink(String link) throws IOException {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
            return 1;
        }
    }

}
