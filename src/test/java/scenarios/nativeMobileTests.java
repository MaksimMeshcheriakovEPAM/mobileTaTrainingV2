package scenarios;

import data.MobileDataProvider;
import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.nativeTestPage.BudgetPage;
import pageObjects.nativeTestPage.LoginPage;
import pageObjects.nativeTestPage.RegistrationPage;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(dataProvider = "nativeDataProvider",
          dataProviderClass = MobileDataProvider.class,
          groups = {"native"},
          description = "Registration and verification performance with Budget page check")
    public void RegistrationTest(User user, String budgetActivity) {
        LoginPage loginPage = (LoginPage) getPo().getPageObject();
        RegistrationPage registrationPage = loginPage.openRegistrationPage();
        registrationPage.register(user, getDriver());
        BudgetPage budgetPage = loginPage.login(user);
        budgetPage.waitForBudgetPage();
        Assert.assertEquals(budgetPage.getBudgetPageName(), budgetActivity);
    }
}
