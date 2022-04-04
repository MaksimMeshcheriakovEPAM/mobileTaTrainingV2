package pages.application;

import support.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AppIndexPage extends NativePageObject {

    public static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = APP_PACKAGE_NAME + "email_sign_in_button")
    private WebElement signInBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_button")
    private WebElement registerUserBtn;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_email")
    private WebElement emailField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "login_pwd")
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
