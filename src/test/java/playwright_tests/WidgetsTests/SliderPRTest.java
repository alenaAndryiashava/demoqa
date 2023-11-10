package playwright_tests.WidgetsTests;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SliderPRTest extends TestBasePR {
    @Test
    public void moveSliderWithKeyboard() {
        page.navigate("https://demoqa.com/slider");
        Locator slider = page.locator(".range-slider--primary");
        slider.focus();
        while (Integer.parseInt(slider.getAttribute("value")) < 40) {
            slider.press("ArrowRight");
        }
        assertThat(page.locator("#sliderValue")).hasValue("40");
    }

    @Test
    public void moveSliderMouseClick() {
        page.navigate("https://demoqa.com/slider");
        Locator slider = page.locator(".range-slider--primary");
        var box = slider.boundingBox();
        page.mouse().click(box.x + box.width / 100 * 40, box.y + box.height / 2);
        assertThat(page.locator("#sliderValue")).hasValue("40");
    }
}
