package scenarios;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.pages.GoogleHomePage;
import setup.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() {
        getDriver().get("http://iana.org");
        waitForPageLoad();
        assertEquals(
                ((WebDriver) getDriver()).getTitle(),
                "Internet Assigned Numbers Authority",
                "This is not IANA homepage");
    }

    /*
    Here I've decided to use simple PageObjects with fluent interaction.
    If I understand correctly it is not necessary to use that "multiplatform" architecture
     */
    @Test(priority = 1, groups = {"web"}, description = "Check Google search engine",
            dataProvider = "DataForGoogleSearchScenario", dataProviderClass = TestData.class)
    public void googleSearchTest(String url, String searchQuery) {
        getDriver().get(url);
        waitForPageLoad();
        int actualSearchResultCount = new GoogleHomePage(getDriver())
                .typeSearchQuery(searchQuery)
                .sendSearchQuery()
                .getMoreResultSearchBlock()
                .size();
        assertTrue(actualSearchResultCount > 0);
    }
}