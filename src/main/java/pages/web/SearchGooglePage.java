package pages.web;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchGooglePage {

    @FindBy(css = "div[data-hveid] > [class*='mnr-c']")
    private List<WebElement> searchResult;


    public SearchGooglePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }


    public List<String> searchTitlesList() {
        return searchResult.stream()
                           .map(WebElement::getText)
                           .collect(Collectors.toList());
    }
}
