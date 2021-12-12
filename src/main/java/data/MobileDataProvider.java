package data;

import org.testng.annotations.DataProvider;
import util.ConfProperty;
import util.UserSetUp;

public class MobileDataProvider {
    private final UserSetUp user;
    private static final String googleUrl = ConfProperty.getProperty("googleURL");
    private static final String request = ConfProperty.getProperty("search");
    private static final String budgetActivity = ConfProperty.getProperty("budgetActivity");

    public MobileDataProvider() {
        user = new UserSetUp();
    }

    @DataProvider
    public Object[][] webDataProvider() {
        return new Object[][] {
            {googleUrl, request}
        };
    }

    @DataProvider
    public Object[][] nativeDataProvider() {
        return new Object[][] {
            {user.getUser(), budgetActivity}
        };
    }
}