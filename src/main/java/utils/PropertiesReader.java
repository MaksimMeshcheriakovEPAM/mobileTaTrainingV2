package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    public static String readProperty(String propertyName) {
        try (FileInputStream fileInputStream = new FileInputStream(
                "src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Property file not found");
        }

        return properties.getProperty(propertyName);
    }
}
