package scenarios;

import static data.UserData.testUser;

import data.UserData;
import org.testng.annotations.Test;
import pages.nativ.BudgetActivityPage;
import pages.nativ.LoginPage;
import setup.BaseTest;

public class BudgetActivityPageTest extends BaseTest {

    @Test(groups = {"native"}, description = "Verify Budget Activity page is opened upon login")
    public void testCanOpenBudgetActivityPage() {
        BudgetActivityPage budgetActivityPage = new LoginPage(getDriver())
            .openRegistrationPage()
            .registerUser(UserData.testUser)
            .loginAs(UserData.testUser);

        budgetActivityPage.shouldHaveAddExpenseBtn();
    }

}
