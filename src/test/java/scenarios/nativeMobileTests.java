package scenarios;

import static org.assertj.core.api.Assertions.assertThat;
import static support.Constants.EMAIL;
import static support.Constants.LOGIN;
import static support.Constants.PASSWORD;

import org.testng.annotations.Test;
import pages.application.AppBudgetActivityPage;
import pages.application.AppIndexPage;
import setup.BaseTest;
import support.User;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          description = "This test for EPAMTestApp, create new account, sing in and check title for BudgetActivityPage")
    public void simpleNativeTest() {
        User defaultUser = new User(EMAIL, LOGIN, PASSWORD);

        AppIndexPage indexPage = (AppIndexPage) setDriverPage().getPage();

        AppBudgetActivityPage appBudgetPage = indexPage.openNewAccountPage()
                                                       .createNewAccount(defaultUser)
                                                       .login(defaultUser);

        assertThat(appBudgetPage.getTitle()).contains(properties.getProperty("budget.page.title"));

        System.out.println("Simplest Android native test done");

    }

}
