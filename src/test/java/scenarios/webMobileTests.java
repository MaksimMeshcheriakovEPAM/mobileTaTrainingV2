package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;
import testData.TestDataProvider;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened Google search homepage", priority = 1)
    public void goToGoogleSearchPage() throws InterruptedException {
        getDriver().get("https://www.google.se/"); // open Google search homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        // Check Google homepage title
        assertThat(((WebDriver) getDriver()).getTitle()).isEqualTo("Google")
                                                        .as("Google search page is opened");
        // Log that test finished
        System.out.println("Site opening done");
    }

    @Test(groups = {"web"}, description = "Search for EPAM", priority = 2, dataProvider = "searchValues",
          dataProviderClass = TestDataProvider.class)
    public void searchForValues(String searchValue) throws InterruptedException {
        // Enter search value in the search field
        WebPageObject.enterValueIntoSearchField(searchValue);
        System.out.println("Search is performed for: " + searchValue);
    }

    @Test(groups = {"web"}, description = "Check page title is correct", priority = 3, dataProvider = "searchValues",
          dataProviderClass = TestDataProvider.class)
    public void checkTitleIsCorrect(String searchValue) throws InterruptedException {
        // Wait for search results to load
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        // Verify page with search results contain correct title
        assertThat(((WebDriver) getDriver()).getTitle()).contains(searchValue)
                                                        .as("Page with search results is opened");
        System.out.println("Page title with search results for: " + searchValue + " is correct");
    }

    @Test(groups = {"web"}, description = "Verify search result is correct", priority = 4,
          dataProvider = "searchValues", dataProviderClass = TestDataProvider.class)
    public void checkSearchResult(String searchValue) throws InterruptedException {

        // Verify search results contain search value
        assertThat(WebPageObject.checkHeadersText(searchValue))
            .as("All headers on search result page contain search value in the headers").isTrue();

        // Log that test finished
        System.out.println("Verification of search page and search results for " + searchValue + " is done");
    }
}
