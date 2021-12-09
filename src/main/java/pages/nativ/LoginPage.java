package pages.nativ;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement emailField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement passwordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public BudgetActivityPage loginAs(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        signInBtn.click();
        return new BudgetActivityPage(appiumDriver);
    }

    public RegistrationPage openRegistrationPage(User user) {
        registerBtn.click();
        return new RegistrationPage(appiumDriver);
    }

}
