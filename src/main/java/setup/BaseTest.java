package setup;

import static java.lang.String.format;
import static util.CloudSetUp.API_KEY;
import static util.CloudSetUp.APPIUM_HUB;
import static util.CloudSetUp.PROJECT_NAME;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.PageObject;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    private static IPageObject po;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return this.po;
    }

    private static void setPo(String appType, AppiumDriver appiumDriver) throws Exception {
        po= new PageObject(appType, appiumDriver);
    }

    public static DesiredCapabilities getDesiredCapabilities(
        String platformName, String browserName, String app,
        String udid, String appPackage, String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        if (app.endsWith(".apk")) {
            capabilities.setCapability(MobileCapabilityType.APP, (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        capabilities.setCapability("bundleId", bundleId);

        return capabilities;
    }

    @Parameters({"appType", "udid", "platformName", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String appType,
                      @Optional("") String udid,
                      String platformName,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        DesiredCapabilities capabilities =
            getDesiredCapabilities(platformName, browserName, app, udid, appPackage, appActivity, bundleId);
        setAppiumDriver(capabilities);
        setPo(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(DesiredCapabilities capabilities) {
        try {
            appiumDriver =
                new AppiumDriver(new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, API_KEY, APPIUM_HUB)),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
