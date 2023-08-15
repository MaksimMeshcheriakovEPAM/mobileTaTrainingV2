package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject  {

    public static final String HOMEPAGE_URL = "https://google.com/";

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//link[contains(@href, 'www.epam.com')]")
    WebElement epamLink;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }
}
