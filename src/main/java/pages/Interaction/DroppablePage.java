package pages.Interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class DroppablePage extends PageBase {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    public DroppablePage testDroppableHere() {
        Actions actions = new Actions(driver);
        wait(1000);

        actions.dragAndDrop(draggable, droppable).perform();
        return this;
    }

    public String getDroppedResult() {
        return droppable.getText();
    }

    public DroppablePage testDroppableByOffset() {
        Actions actions = new Actions(driver);

        int xOffSetDraggable = draggable.getLocation().getX();//перетаскиваемый
        int yOffSetDraggable = draggable.getLocation().getY();

        int xOffSetDroppable = droppable.getLocation().getX();//сбрасываемый
        int yOffSetDroppable = droppable.getLocation().getY();

        int xOffSet = (xOffSetDroppable - xOffSetDraggable) + 30;
        int yOffSet = (yOffSetDroppable - yOffSetDraggable) + 30;

        actions.dragAndDropBy(draggable, xOffSet, yOffSet).perform();


        wait(1000);

        return this;
    }
}
