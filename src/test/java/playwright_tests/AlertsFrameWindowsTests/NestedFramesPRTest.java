package playwright_tests.AlertsFrameWindowsTests;

import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NestedFramesPRTest extends TestBasePR {
    @Test
    public void verifyTextInParentChildFrames() {
        page.navigate("https://demoqa.com/nestedframes");

        assertThat(
                page.frameLocator("#frame1")
                        .locator("body"))
                .containsText("Parent");

        assertThat(
                page.frameLocator("#frame1")
                        .frameLocator("iframe")
                        .locator("body > p"))
                .containsText("Child Iframe");
    }
}
