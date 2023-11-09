package playwright_tests.AlertsFrameWindowsTests;

import com.microsoft.playwright.Dialog;
import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsPRTest extends TestBasePR {
    @Test
    public void confirmBoxTestOk() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog -> dialog.accept());
        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("Ok");
    }

    @Test
    public void confirmBoxTestCancel() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(Dialog::dismiss);
        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("Cancel");
    }

    @Test
    public void confirmPromptBoxTestCancel() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog -> dialog.accept("hello"));
        page.locator("#promtButton").click();

        assertThat(page.locator("#promptResult")).containsText("hello");
    }
}
