package scenarios;

import static support.Constants.EMAIL;
import static support.Constants.LOGIN;
import static support.Constants.PASSWORD;

import pages.application.AppBudgetActivityPage;
import pages.application.AppIndexPage;
import setup.BaseTest;
import support.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          description = "This test for EPAMTestApp, create new account, sing in and check title for BudgetActivityPage")
    public void simpleNativeTest() {
        User defaultUser = new User(EMAIL, LOGIN, PASSWORD);

        AppIndexPage indexPage = (AppIndexPage) setDriverPage().getPage();

        AppBudgetActivityPage appBudgetPage = indexPage.openNewAccountPage()
                                                       .createNewAccount(defaultUser)
                                                       .login(defaultUser);

        Assert.assertEquals(appBudgetPage.getTitle(), properties.getProperty("budget.page.title"));

        System.out.println("Simplest Android native test done");

    }

}
