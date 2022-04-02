package com.epam.tc.hw02.pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import com.epam.tc.hw02.support.User;

public class AppNewAccountPage extends NativePageObject {

    public static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_email")
    private WebElement emailRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_username")
    private WebElement loginRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_password")
    private WebElement passwordRegisterField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    private WebElement confirmPasswordField;

    @AndroidFindBy(id = APP_PACKAGE_NAME + "register_new_account_button")
    private WebElement createNewUserBtn;

    public AppNewAccountPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public AppIndexPage createNewAccount(User user) {
        emailRegisterField.sendKeys(user.getEmail());
        loginRegisterField.sendKeys(user.getLogin());
        passwordRegisterField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
        createNewUserBtn.click();
        return new AppIndexPage(driver);
    }
}
