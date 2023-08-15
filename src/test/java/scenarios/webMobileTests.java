package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

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
        openPage();
        searchForTerm("EPAM");
        assert getDriver().getTitle().contains("EPAM") : "This page doesn't contain search results for EPAM";
        assert getPo().getWelement("epamLink").isEnabled() : "There is no EPAM link on the page";
    }

    private void openPage() {
        getDriver().get(WebPageObject.HOMEPAGE_URL); // open google.
        pageLoaded();
    }
    private void searchForTerm(String term) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("searchField").clear();
        getPo().getWelement("searchField").sendKeys(term);
        getPo().getWelement("searchField").sendKeys(Keys.RETURN);
        pageLoaded();
    }

    private void pageLoaded() {
        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

}
