package pageObjects.activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.ElementSupplier;

public class BudgetActivity implements ElementSupplier {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    WebElement addExpenseBtn;

    public BudgetActivity(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}