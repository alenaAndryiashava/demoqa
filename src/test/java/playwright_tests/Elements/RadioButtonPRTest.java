package playwright_tests.Elements;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RadioButtonPRTest extends TestBasePR {
    @Test
    public void selectRadioButtons() {
        page.navigate("https://demoqa.com/radio-button");
        page.locator("#yesRadio").check(new Locator.CheckOptions().setForce(true));

        assertThat(page.locator(".text-success")).containsText("Yes");
    }
}
