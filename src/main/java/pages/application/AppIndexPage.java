package pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import support.User;

public class AppIndexPage extends NativePageObject {

    public static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = APP_PACKAGE_NAME + "email_sign_in_button")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@value='Sign In']")
    private WebElement signInBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_button")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private WebElement registerUserBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_email")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement emailField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_pwd")
    @iOSXCUITFindBy (xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement passwordField;

    public AppIndexPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public AppBudgetActivityPage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        signInBtn.click();
        return new AppBudgetActivityPage(driver);
    }

    public AppNewAccountPage openNewAccountPage() {
        registerUserBtn.click();
        return new AppNewAccountPage(driver);
    }
}
