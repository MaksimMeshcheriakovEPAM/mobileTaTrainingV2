package pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import support.User;

public class AppNewAccountPage extends NativePageObject {

    public static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement emailRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private WebElement loginRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement passwordRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private WebElement confirmPasswordField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    private WebElement createNewUserBtn;

    public AppNewAccountPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public AppIndexPage createNewAccount(User user) {
        emailRegisterField.sendKeys(user.getEmail());
        loginRegisterField.sendKeys(user.getLogin());
        passwordRegisterField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
        driver.hideKeyboard();
        createNewUserBtn.click();
        return new AppIndexPage(driver);
    }

}
