package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject  {

    @FindBy(className = "//*[@id= 'APjFqb']")
    public static WebElement searchField;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public static void enterValueIntoSearchField(String searchText){
        searchField.click();
        searchField.sendKeys(searchText);
    }

}
