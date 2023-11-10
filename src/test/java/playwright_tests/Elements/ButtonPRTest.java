package playwright_tests.Elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ButtonPRTest extends TestBasePR {
    @Test
    public void buttonsClicks(){
        page.navigate("https://demoqa.com/buttons");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                        .setName("Double Click me"))
                .dblclick();
        assertThat(page.locator("#doubleClickMessage"))
                .containsText("double click");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                        .setName("Right Click me"))
                .click(new Locator.ClickOptions()
                        .setButton(MouseButton.RIGHT));

        assertThat(page.locator("#rightClickMessage"))
                .containsText("right click");

    }
}
