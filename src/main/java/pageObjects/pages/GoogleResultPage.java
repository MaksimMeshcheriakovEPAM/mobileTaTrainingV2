package pageObjects.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleResultPage {

    private AppiumDriver driver;
    private String query = "";

    private String xpath = "//div[text() = 'More results']/../..//div[contains(text(), '" + query + "')]";

    public GoogleResultPage(AppiumDriver appiumDriver, String query) {
        PageFactory.initElements(appiumDriver, this);
        this.driver = appiumDriver;
        this.query = query;
    }

    public List getMoreResultSearchBlock() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[text() = 'More results']")));
        return driver.findElements(By.xpath(xpath));
    }
}