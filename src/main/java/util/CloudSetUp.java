package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CloudSetUp {
    public static final String PROJECT_NAME = ConfProperty.getProperty("projectName");
    public static final String APPIUM_HUB = ConfProperty.getProperty("appiumHub");
    public static String API_KEY;

    static {
        try {
            API_KEY = URLEncoder.encode(ConfProperty.getProperty("apiKey"), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}
