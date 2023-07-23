package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/application.properties")){
            properties.load(fis);
        } catch (IOException exception) {
            System.out.println("File Not Found!");
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
