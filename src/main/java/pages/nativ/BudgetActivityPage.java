package pages.nativ;

import static org.testng.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class BudgetActivityPage extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    WebElement addExpenseBtn;

    public BudgetActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public BudgetActivityPage shouldHaveAddExpenseBtn() {
        assertTrue(addExpenseBtn.isDisplayed(), "ADD EXPENSE button is not displayed");
        System.out.println("ADD EXPENSE button is displayed");
        return this;
    }

}
