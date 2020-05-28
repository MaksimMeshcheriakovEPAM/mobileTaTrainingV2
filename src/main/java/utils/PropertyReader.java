package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String PATH = "src/test/resources/config.properties";

    public static String get(String property) {
	    try(FileInputStream fileInputStream = new FileInputStream(PATH)) {
	    	Properties properties = new Properties();
	        properties.load(fileInputStream);
	        return properties.getProperty(property);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return null;
    }

}