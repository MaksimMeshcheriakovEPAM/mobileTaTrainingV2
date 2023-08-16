package scenarios;

import dto.User;
import flow.NativeAppFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;
import utils.DtoGenerator;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button",
            enabled = false)
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("okBtn").click();
        getPo().getWelement("signInBtn").click();
        System.out.println("Simplest Android native test done");

    }

    @Test(groups = {"native"}, description = "The user gets to the BudgetActivity page after logging in")
    public void budgetActivityPageAfterLoggingInTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        User user = DtoGenerator.generateUser();
        NativeAppFlow nativeStep = new NativeAppFlow();
        getPo().getWelement("okBtn").click();
        nativeStep.registration(user);
        nativeStep.login(user);
        String pageTitle = nativeStep.getPageTitle();
        Assert.assertEquals(pageTitle, "BudgetActivity");
    }
}
