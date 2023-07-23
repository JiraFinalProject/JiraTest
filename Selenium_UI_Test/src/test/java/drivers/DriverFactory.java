package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    private static WebDriver createWebDriver() {
        WebDriver webDriver;
        try (FileInputStream input = new FileInputStream("src/test/resources/application.properties")){
            Properties properties = new Properties();
            properties.load(input);

            switch (properties.getProperty("driver").toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("browser type is not supported!");
                }
            }
            webDriver.manage().window().maximize();
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return webDriver;
    }
    public static WebDriver getDriver() {
        if (driverLocal.get() == null) {
            driverLocal.set(createWebDriver());
        }
        return driverLocal.get();
    }

    public static void teardown() {
        if (driverLocal.get() != null) {
            driverLocal.get().quit();
            driverLocal.remove();
        }
    }

}