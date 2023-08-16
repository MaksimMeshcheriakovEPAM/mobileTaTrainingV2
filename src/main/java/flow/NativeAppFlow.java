package flow;

import dto.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.NativePageObject;
import setup.BaseTest;

public class NativeAppFlow extends BaseTest {

    public void registration(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.
                visibilityOf(getPo().getWelement("registerBtn"))).click();
        getPo().getWelement("regEmail").sendKeys(user.getEmail());
        getPo().getWelement("regUsername").sendKeys(user.getUsername());
        getPo().getWelement("regPassword").sendKeys(user.getPassword());
        getPo().getWelement("regConfirmPassword").sendKeys(user.getPassword());
        getPo().getWelement("confirmCheckbox").click();
        getPo().getWelement("registerNewAccountBtn").click();
    }

    public void login(User user) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getPo().getWelement("loginEmail").sendKeys(user.getEmail());
        getPo().getWelement("loginPwd").sendKeys(user.getPassword());
        getPo().getWelement("signInBtn").click();
    }

    public String getPageTitle() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.stalenessOf(getPo().getWelement("actionBar")));
        return getPo().getWelement("actionBar").findElement(By.className(NativePageObject.TEXT_ON_PAGE)).getText();
    }
}
