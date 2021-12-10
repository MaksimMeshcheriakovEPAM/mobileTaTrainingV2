package pages.web;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class GoogleMainPage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//li[@role='presentation']")
    private List<WebElement> suggestions;

    public GoogleMainPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(appiumDriver, this);
    }

    public GoogleSearchPage search(String text) {
        searchField.sendKeys(text);
        suggestions.get(0).click();
        return new GoogleSearchPage(appiumDriver);
    }

}
