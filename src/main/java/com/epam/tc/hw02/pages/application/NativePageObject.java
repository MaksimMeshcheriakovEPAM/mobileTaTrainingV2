package com.epam.tc.hw02.pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject {

    protected AppiumDriver driver;

    public NativePageObject(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }
}
