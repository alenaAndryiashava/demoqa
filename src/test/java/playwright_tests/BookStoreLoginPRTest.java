package playwright_tests;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import pages.Data.LoginData;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BookStoreLoginPRTest extends TestBasePR{
    @Test
    public void positiveAuthTest(){
        page.navigate("https://demoqa.com/");
        page.locator("//div[6]").click();
        page.getByRole(AriaRole.LIST).getByText("Login").click();

        assertThat(page).hasTitle(Pattern.compile("DEMOQA"));

        page.locator("input[id='userName']").click();
        page.locator("input[id='userName']").fill(LoginData.USERNAME);
        page.getByPlaceholder("Password").click();
        page.getByPlaceholder("Password").fill(LoginData.PASSWORD);

        page.locator("#login").click();
        assertThat(page.locator("#userName-value"))
                .containsText(LoginData.USERNAME);
    }
}

