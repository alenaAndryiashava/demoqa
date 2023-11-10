package playwright_tests.Elements;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import playwright_tests.TestBasePR;

import java.net.URI;
import java.net.URISyntaxException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BrokenLinksImagesPRTest extends TestBasePR {
    // Title: Check page for broken links (status code of the target link is >= 400)
    @Test
    public void checkBrokenLinks() {
        page.navigate("https://demoqa.com/broken");

        for (Locator link : page.getByRole(AriaRole.LINK).all()) {
            System.out.println(link.textContent());
            APIResponse response = page.request()
                    .get(link.getAttribute("href"));
            assertThat(response).isOK();
        }
    }

    @Test
    public void checkBrokenImages() throws URISyntaxException {
        //images/Toolsqa_1.jpg ->Rel XPath not AbsXPath!!
        page.navigate("https://demoqa.com/broken");
        for (Locator image : page.getByRole(AriaRole.IMG).all()) {
            String src = image.getAttribute("src");
            System.out.println(src);
            //http(s) + :// + host + src
            URI uri = new URI(page.url());
            //uri.getScheme() --http
            //uri.getHost() --demoqa.com
            if (!src.startsWith("http")) src = uri.getScheme() + "://" + uri.getHost() + src;
            System.out.println(src);
            APIResponse response = page.request().get(src);
            assertThat(response).isOK();
            Assertions.assertTrue(response.headers()
                    .get("content-type").contains("image"));
            assertNotEquals(0, image
                    .evaluate("node => node.naturalWidth"), "Failed: image naturalWidth == 0");
        }
    }
}

