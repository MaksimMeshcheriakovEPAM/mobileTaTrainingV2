package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.PropertyReader.get;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "go to a Google search page and make a search using keyword ‘EPAM’. Make sure that there are some relevant results")
    public void webTest() throws InterruptedException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        getDriver().get(get("url"));

        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(get("search"));
        getPo().getWelement("searchBtn").click();

        assert getPo().getWelement("searchResults").isDisplayed() : "Results are empty";
        System.out.println("Android web test done");
    }

}
