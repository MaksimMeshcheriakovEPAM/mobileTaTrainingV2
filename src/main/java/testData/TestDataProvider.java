package testData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    // Data provider for registration test data
    @DataProvider(name = "registrationData")
    public Object[][] registrationDataProvider() throws Exception {
        // Read test data from test data file
        JSONObject config = TestDataReader.readNativeTestData();
        JSONArray registrationData = config.getJSONArray("registrationData");
        // Structure to hold the test data
        Object[][] data = new Object[registrationData.length()][1];
        for (int i = 0; i < registrationData.length(); i++) {
            data[i][0] = registrationData.getJSONObject(i);
        }
        return data;
    }

    // Data provider for login test data
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() throws Exception {
        // Read test data from test data file
        JSONObject config = TestDataReader.readNativeTestData();
        JSONArray registrationData = config.getJSONArray("loginData");
        // Structure to hold the test data
        Object[][] data = new Object[registrationData.length()][1];
        for (int i = 0; i < registrationData.length(); i++) {
            data[i][0] = registrationData.getJSONObject(i);
        }
        return data;
    }

    // Data provider for search values test data
    @DataProvider(name = "searchValues")
    public Object[][] getSearchValues() {
        // Provide search values for test
        return new Object[][] {
            {"EPAM"}
        };
    }
}
