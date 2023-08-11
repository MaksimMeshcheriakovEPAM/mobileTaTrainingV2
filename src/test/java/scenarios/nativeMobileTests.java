package scenarios;

import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

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
        User user = new User()
                .setEmail("testEmail@example.com")
                .setUsername("testUsername")
                .setPassword("testPassword123");
        getPo().getWelement("okBtn").click();
        registerUser(user);
        loginUser(user);
        String pageTitle = getPageTitle();
        Assert.assertEquals(pageTitle, "BudgetActivity");
    }

    private void registerUser(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                visibilityOf(getPo().getWelement("registerBtn"))).click();
        getPo().getWelement("regEmail").sendKeys(user.getEmail());
        getPo().getWelement("regUsername").sendKeys(user.getUsername());
        getPo().getWelement("regPassword").sendKeys(user.getPassword());
        getPo().getWelement("regConfirmPassword").sendKeys(user.getPassword());
        getPo().getWelement("confirmCheckbox").click();
        getPo().getWelement("registerNewAccountBtn").click();
    }

    private void loginUser(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("loginEmail").sendKeys(user.getEmail());
        getPo().getWelement("loginPwd").sendKeys(user.getPassword());
        getPo().getWelement("signInBtn").click();
    }

    private String getPageTitle() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.stalenessOf(getPo().getWelement("actionBar")));
        return getPo().getWelement("actionBar").findElement(By.className(NativePageObject.TEXT_ON_PAGE)).getText();
    }

}
