package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;
import pageObjects.NativePageObject;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Click on 'Register new account' button", priority = 1)
    public void goToRegistrationPage() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("registerNewAccountButton").isDisplayed())
            .as("Button for registration of a new account is displayed").isTrue();
        getPo().getWelement("registerNewAccountButton").click();
        System.out.println("'Register new account' button is displayed and can be clicked");
    }

    @Test(groups = {"native"}, description = "Check if user is on registration page", priority = 2)
    public void checkRegistrationPageIsOpened() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("registrationForm").isDisplayed())
            .as("Registration form is displayed").isTrue();
        System.out.println("User is on registration page");
    }
    @Test(groups = {"native"}, description = "Check email field is displayed and user's email can be filled in",
          priority = 3)
    public void fillInEmailField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("emailField").isDisplayed())
            .as("Email field is displayed").isTrue();
        getPo().getWelement("emailField").sendKeys("jk@gmail.com");
        System.out.println("Email field is displayed and can be filled in");
    }
    @Test(groups = {"native"}, description = "Check username field is displayed and can be filled in", priority = 4)
    public void fillInUsernameField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("usernameField").isDisplayed())
            .as("Username field is displayed").isTrue();
        getPo().getWelement("usernameField").sendKeys("Julia");
        System.out.println("Username field is displayed and can be filled in");
    }
    @Test(groups = {"native"}, description = "Check password field is displayed and can be filled in", priority = 5)
    public void fillInPasswordField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("passwordField").isDisplayed())
            .as("Password field is displayed").isTrue();
        getPo().getWelement("passwordField").sendKeys("admin12345");
        System.out.println("Password field is displayed and can be filled in");
    }
    @Test(groups = {"native"}, description = "Check field for password confirmation is displayed and can be filled in",
          priority = 5)
    public void confirmPasswordField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("confirmPassField").isDisplayed())
            .as("Field for password confirmation is displayed").isTrue();
        getPo().getWelement("confirmPassField").sendKeys("admin12345");
        System.out.println("Field for password confirmation is displayed and can be filled in");
    }
    @Test(groups = {"native"}, description = "Check agreement checkbox is displayed and can be checked",
          priority = 6)
    public void checkAgreementCheckbox() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("agreementCheckbox").isDisplayed())
            .as("Agreement checkbox is displayed").isTrue();
        getPo().getWelement("agreementCheckbox").click();
        System.out.println("Agreement checkbox is displayed and can be checked");
    }
    @Test(groups = {"native"},
          description = "Check 'Register new account' button is displayed and new account can be registered",
          priority = 7)
    public void confirmRegistration() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("registerNewAccountBtn").isDisplayed())
            .as("Button 'Register new account' is displayed").isTrue();
        getPo().getWelement("registerNewAccountBtn").click();
        System.out.println("Button 'Register new account' is displayed and can be clicked");
    }
    @Test(groups = {"native"}, description = "Check if user is on login page", priority = 8)
    public void checkLoginPageIsOpened() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("loginForm").isDisplayed())
            .as("Login form is displayed").isTrue();
        System.out.println("User is on login page");
    }
    @Test(groups = {"native"}, description = "Check login field is displayed and user's email can be filled in",
          priority = 9)
    public void fillInLoginField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("loginEmailField").isDisplayed())
            .as("Login field is displayed").isTrue();
        getPo().getWelement("loginEmailField").sendKeys("jk@gmail.com");
        System.out.println("Login field is displayed and can be filled in");
    }
    @Test(groups = {"native"}, description = "Check login field is displayed and user's email can be filled in",
          priority = 10)
    public void fillInLoginPasswordField() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("loginPwdField").isDisplayed())
            .as("Login password field is displayed").isTrue();
        getPo().getWelement("loginPwdField").sendKeys("admin12345");
        System.out.println("Login password field is displayed and can be filled in");
    }

    @Test(groups = {"native"}, description = "Check login is performed",
          priority = 11)
    public void performLogin() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("signInBtn").click();
        System.out.println("'Sign in' button is clicked");

    }
    @Test(groups = {"native"}, description = "Check if user is on BudgetActivity page",
          priority = 12)
    public void checkIfBudgetActivityPageIsOpened() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        assertThat(getPo().getWelement("BudgetActivityHeader").getText()).isEqualTo("BudgetActivity");
        System.out.println("BudgetActivity page is opened");
    }
}
