package pages;

import pages.application.AppIndexPage;
import pages.web.WebIndexPage;
import io.appium.java_client.AppiumDriver;

public class PageObject {

    Object somePage; // it should be set of web page or EPAM Test App WebElements

    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                somePage = new WebIndexPage(appiumDriver);
                break;
            case "native":
                somePage = new AppIndexPage(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }
    }

    public Object getPage() {
        return somePage;
    }
}
