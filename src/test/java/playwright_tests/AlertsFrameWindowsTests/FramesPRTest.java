package playwright_tests.AlertsFrameWindowsTests;

import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesPRTest extends TestBasePR {
    @Test
    public void switchToFrameById(){
        page.navigate("https://demoqa.com/frames");

        assertThat(
                page.frameLocator("#frame1").locator("#sampleHeading")).containsText("sample");
    }
}
