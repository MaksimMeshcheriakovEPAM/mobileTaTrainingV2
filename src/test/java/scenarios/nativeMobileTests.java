package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import static utils.PropertyReader.get;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "register a new account and then sign in. Make sure that you are on the BudgetActivity page")
    public void nativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
    	//Account registration
        getPo().getWelement("registerBtn").click();
        getPo().getWelement("registrationEmail").sendKeys(get("email"));
        getPo().getWelement("registrationUsername").sendKeys(get("username"));
        getPo().getWelement("registrationPassword").sendKeys(get("password"));
        getPo().getWelement("registrationConfirmPassword").sendKeys(get("password"));
        getPo().getWelement("registerNewAccountBtn").click();

        //Sign in
        getPo().getWelement("loginEmail").sendKeys(get("email"));
        getPo().getWelement("loginPwd").sendKeys(get("password"));
        getPo().getWelement("signInBtn").click();

        assert getPo().getWelement("frameTitle").getText().equals(get("title")) : "This is not expected title";
        System.out.println("Android native test done");
    }

}
