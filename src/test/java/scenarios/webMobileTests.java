package scenarios;

import flow.GooglePageFlow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import utils.PropertiesReader;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage",
            enabled = false)
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }

    @Test(groups = {"web"}, description = "Make sure that on page should be some relevant results")
    public void searchTest() throws InterruptedException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        GooglePageFlow googlePageFlow = new GooglePageFlow();
        googlePageFlow.openPage();
        googlePageFlow.searchForTerm(PropertiesReader.readProperty("search.term"));
        assert getDriver().getTitle().contains(PropertiesReader.readProperty("search.term")) : "This page doesn't contain search results for EPAM";
        assert googlePageFlow.isLinkPresent(PropertiesReader.readProperty("search.link")) :
                "There is no EPAM link on the page";
    }
}
