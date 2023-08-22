package pageObjects;

import static java.sql.DriverManager.getDriver;

import io.appium.java_client.AppiumDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageObject {

    @FindBy(xpath = "//input[@name='q']")
    public static WebElement searchField;
    @FindBy(xpath = "//h3[@class = 'LC20lb MBeuO DKV0Md']")
    public static List<WebElement> searchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public static void enterValueIntoSearchField(String searchText) {
        searchField.click();
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
    }

    public static boolean checkHeadersText(String expectedSearchValue) {
        boolean areHeaderTextsMatchSearchValue = true;

        for (WebElement result : searchResults) {
            String resultText = result.getText();
            if (!resultText.contains(expectedSearchValue)) {
                areHeaderTextsMatchSearchValue = false;
            }
        }
        return areHeaderTextsMatchSearchValue;
    }
}
