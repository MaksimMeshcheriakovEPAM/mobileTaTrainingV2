package com.epam.tc.hw02.pages.web;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebIndexPage {

    AppiumDriver driver;

    @FindBy(css = "input[type='search']")
    private WebElement searchField;

    public WebIndexPage(AppiumDriver appiumDriver) {
        driver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public WebIndexPage openUrl(String url) {
        driver.get(url);
        return this;
    }

    public SearchGooglePage sendRequest(String request) {
        searchField.sendKeys(request, Keys.RETURN);
        return new SearchGooglePage(driver);
    }
}
