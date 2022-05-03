package pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AppBudgetActivityPage extends NativePageObject {

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='Budget']")
    private WebElement headerOfPage;

    public AppBudgetActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getTitle() {
        return headerOfPage.getText();
    }
}
