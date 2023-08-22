package testData;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class TestDataReader {
    // Read and parse test data from a JSON file with test data for native mobile tests
    public static JSONObject readNativeTestData() throws Exception {
        String configFile = "nativeMobileTestData.json";
        String configContent = Files.readString(Paths.get(configFile));
        return new JSONObject(configContent);
    }
}
