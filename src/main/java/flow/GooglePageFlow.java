package flow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.WebPageObject;
import setup.BaseTest;

public class GooglePageFlow extends BaseTest {

    public void openPage() {
        getDriver().get(WebPageObject.HOMEPAGE_URL); // open google.
        pageLoaded();
    }

    public void searchForTerm(String term) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("searchField").clear();
        getPo().getWelement("searchField").sendKeys(term);
        getPo().getWelement("searchField").sendKeys(Keys.RETURN);
        pageLoaded();
    }

    public boolean isLinkPresent(String link) {
        return getDriver().findElements(By.xpath(String.format(WebPageObject.LINK, link))).size() > 0;
    }

    private void pageLoaded() {
        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }
}
