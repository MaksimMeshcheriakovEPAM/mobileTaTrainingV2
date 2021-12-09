package pages;

import io.appium.java_client.AppiumDriver;

public class BasePage {

    protected AppiumDriver appiumDriver;

    public BasePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
}
