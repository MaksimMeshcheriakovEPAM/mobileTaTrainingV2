package scenarios;

import data.MobileDataProvider;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.webTestPage.WebPageObject;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(dataProvider = "webDataProvider",
          dataProviderClass = MobileDataProvider.class,
          groups = {"web"},
          description = "Relevant results assert for search 'Epam' request in the Google")
    public void WebTest(String googleURL, String req) {
        WebPageObject googlePage = (WebPageObject) getPo().getPageObject();
        googlePage.openPage(googleURL);
        googlePage.search(req);
        List<WebElement> resultList = googlePage.getSearchResult();
        for (WebElement result : resultList) {
            Assert.assertTrue(result.getText().toLowerCase()
                                        .contains(req.toLowerCase()));
        }
    }
}
