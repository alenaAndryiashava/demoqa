package pages.WidgetsPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.PageBase;

public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div")
    WebElement selectValueSelect;
    @FindBy(id = "selectMenuContainer")
    WebElement containerFreeSpace;
    @FindBy(xpath = "//*[@id=\"selectOne\"]/div/div[1]")
    WebElement selectValueOne;
    //@FindBy (id = "oldSelectMenu")
    @FindBy(xpath = "//*[@id='oldSelectMenu']")
    WebElement oldSelectMenu;
    @FindBy(xpath = "//select[@id='cars']")
    WebElement selectCarWithStandardMultiSelect;

    public SelectMenuPage choseFromSelectValue() {
        //type(selectValueSelect, "Group 1");
        Actions actions = new Actions(driver);
        actions.sendKeys(selectValueSelect, "Group 1, option 1" + Keys.ENTER).perform();
        click(containerFreeSpace);
        wait(3000);
        return this;
    }

    public SelectMenuPage choseFromSelectOne() {
        Actions actions = new Actions(driver);
        actions.sendKeys(selectValueOne, "Prof" + Keys.ENTER).perform();
        click(containerFreeSpace);
        wait(3000);
        return this;
    }

    public String getSelectValueText() {
        return selectValueSelect.getText();
    }

    public String getSelectOneText() {
        return selectValueOne.getText();
    }

    public SelectMenuPage choseYellowFromOldStyleSelect() {
        Select select = new Select(oldSelectMenu);
        select.selectByValue("3");
        return this;
    }

    public String getOldStyleSelectValueText() {
        Select select = new Select(oldSelectMenu);
        return select.getFirstSelectedOption().getText();
    }

    public SelectMenuPage choseCarFromStandardMultiSelect(String car) {
        //WebElement mySelectCar = driver.findElement(By.name(car));
        Select select = new Select(selectCarWithStandardMultiSelect);
        select.selectByVisibleText(car);
        return this;
    }

    public String getCarText() {
        return selectCarWithStandardMultiSelect.getText();
    }
}
