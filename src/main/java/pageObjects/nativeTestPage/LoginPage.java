package pageObjects.nativeTestPage;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = BASE_PATH + "email_sign_in_button")
    WebElement signInBtn;

    @AndroidFindBy(id = BASE_PATH + "register_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = BASE_PATH + "login_email")
    private WebElement email;

    @AndroidFindBy(id = BASE_PATH + "login_pwd")
    private WebElement pass;

    public LoginPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationPage openRegistrationPage() {
        appiumDriver.hideKeyboard();
        registerBtn.click();
        return new RegistrationPage(appiumDriver);
    }

    public BudgetPage login(User user) {
        email.sendKeys(user.getEmail());
        pass.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        signInBtn.click();
        return new BudgetPage(appiumDriver);
    }
}
