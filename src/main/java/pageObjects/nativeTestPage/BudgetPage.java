package pageObjects.nativeTestPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BudgetPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    private WebElement budgetActionBar;

    @AndroidFindBy(id = BASE_PATH + "add_new_expense")
    private WebElement addExpenseBtn;

    public BudgetPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitForBudgetPage() {
        new WebDriverWait(appiumDriver, 30)
            .until(ExpectedConditions.visibilityOf(addExpenseBtn));
    }

    public String getBudgetPageName() {
        return budgetActionBar.getText();
    }
}
