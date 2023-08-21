package scenarios;

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

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we've opened Google search homepage", priority = 1)
    public void goToGoogleSearchPage() throws InterruptedException {
        getDriver().get("https://www.google.se/"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        // Check Google homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Google") : "This is Google search page";
        // Log that test finished
        System.out.println("Site opening done");
    }
    @Test(groups = {"web"}, description = "Search for EPAM", priority = 2)
    public void searchForValues() throws InterruptedException {
        // Enter search query "EPAM" in the search input
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@name='q']"));
        searchInput.click();
        searchInput.sendKeys("EPAM");
        searchInput.sendKeys(Keys.ENTER);
        System.out.println("Search is performed");
    }
    @Test(groups = {"web"}, description = "Check page title is correct", priority = 3)
    public void checkTitleIsCorrect() throws InterruptedException {
        // Wait for search results to load
        new WebDriverWait(getDriver(), 10).until(
            ExpectedConditions.titleContains("EPAM - Google'da Ara")
        );

        // Verify search results, you can add your verification steps here
        List<WebElement> searchResults = getDriver().findElements(By.cssSelector("h3"));
        for (WebElement result : searchResults) {
            String resultText = result.getText();
            // Perform your assertions or verifications on resultText
        }

        // Log that test finished
        System.out.println("Verification of page is done");
    }

}
