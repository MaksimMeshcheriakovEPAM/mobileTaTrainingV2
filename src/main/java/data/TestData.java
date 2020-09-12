package data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "DataForIncorrectLoginScenario")
    public Object[][] getDataForIncorrectLogin() {
        return new Object[][]{
                {"LoginActivity", "Incorrect email or password"}
        };
    }

    @DataProvider(name = "DataForRegistrationScenario")
    public Object[][] getDataForRegistration() {
        return new Object[][]{
                {"LoginActivity", "RegistrationActivity", "BudgetActivity", "ADD EXPENSE"}
        };
    }

    @DataProvider(name = "DataForGoogleSearchScenario")
    public Object[][] getDataForGoogleSearch() {
        return new Object[][]{
                {"https://www.google.com/", "EPAM"}
        };
    }
}