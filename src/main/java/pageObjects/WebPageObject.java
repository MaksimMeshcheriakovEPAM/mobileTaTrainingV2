package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    public static final String HOMEPAGE_URL = "https://google.com/";
    public static final String LINK = "//a[contains(@href, '%s')]";

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
