package pageObjects.nativeTestPage;

import entity.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @AndroidFindBy(id = BASE_PATH + "registration_email")
    private WebElement regEmail;

    @AndroidFindBy(id = BASE_PATH + "registration_username")
    private WebElement regUserName;

    @AndroidFindBy(id = BASE_PATH + "registration_password")
    private WebElement regPass;

    @AndroidFindBy(id = BASE_PATH + "registration_confirm_password")
    private WebElement regRepPass;

    @AndroidFindBy(id = BASE_PATH + "register_new_account_button")
    private WebElement regBtn;

    public RegistrationPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationPage register(User user, AppiumDriver appiumDriver) {
        regEmail.sendKeys(user.getEmail());
        regUserName.sendKeys(user.getUserName());
        regPass.sendKeys(user.getPassword());
        regRepPass.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        regBtn.click();
        return this;
    }
}
