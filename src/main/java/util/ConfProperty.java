package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperty {

    protected static Properties properties;
    protected static String PATH = "src/test/resources/test.properties";

    public ConfProperty() {
    }

    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    static {
        try (FileInputStream fileInputStream = new FileInputStream(PATH)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
