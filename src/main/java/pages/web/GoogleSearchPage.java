package pages.web;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class GoogleSearchPage extends BasePage {

    @FindBy(xpath = "// div[@role='heading'] // div")
    private List<WebElement> resultHeaders;

    public GoogleSearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements(appiumDriver, this);
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public List<String> getResultHeaders() {
        return resultHeaders.stream().map(head -> head.getText()).collect(Collectors.toList());
    }
}
