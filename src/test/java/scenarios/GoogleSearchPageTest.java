package scenarios;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Locale;
import org.testng.annotations.Test;
import pages.web.GoogleMainPage;
import pages.web.GoogleSearchPage;
import setup.BaseTest;

public class GoogleSearchPageTest extends BaseTest {

    private String searchText = "EPAM";
    private String resultStatusRegex = "About [\\d,]+ results";

    @Test(groups = {"web"}, description = "Verify google search returns relevant results")
    public void testGoogleSearchPage() {
        getDriver().get("https://google.com");
        GoogleSearchPage googleSearchPage = new GoogleMainPage(getDriver()).search(searchText);

        String resultHeader = googleSearchPage.getResultHeaders().stream()
            .filter(header -> containsStringIgnoreCase(header, searchText))
            .findAny()
            .get();

        assertNotNull(resultHeader, "No relevant results present on the page");
    }

    private boolean containsStringIgnoreCase(String text, String string) {
        return text.toLowerCase(Locale.ROOT).contains(string.toLowerCase(Locale.ROOT));
    }

}
