package pageObjects.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    private AppiumDriver driver;
    private String query;

    @FindBy(css = "input[name='q']")
    WebElement searchField;

    @FindBy(css = "input[value='Google Search']")
    WebElement searchBtn;

    public GoogleHomePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        this.driver = appiumDriver;
    }

    public GoogleHomePage typeSearchQuery(String query) {
        searchField.sendKeys(query);
        this.query = query;
        return this;
    }

    public GoogleResultPage sendSearchQuery() {
        searchField.sendKeys(Keys.ENTER);
        return new GoogleResultPage(driver, query);
    }
}