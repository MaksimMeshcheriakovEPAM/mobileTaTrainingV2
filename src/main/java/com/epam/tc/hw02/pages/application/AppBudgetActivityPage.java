package com.epam.tc.hw02.pages.application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class AppBudgetActivityPage extends NativePageObject {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout"
        + "/android.widget.LinearLayout/android.widget.FrameLayout"
        + "/android.view.ViewGroup/android.widget.FrameLayout[2]"
        + "/android.view.ViewGroup/android.widget.TextView")
    private WebElement headerOfPage;

    public AppBudgetActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getTitle() {
        return headerOfPage.getText();
    }
}
