package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ApplicationProperties;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            setupDriver();
        }
        return webDriver.get();
    }

    private static void setupDriver() {
        switch (ApplicationProperties.get("browserType").toLowerCase()) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                webDriver.set(new EdgeDriver());
                break;
            }
            default: {
                System.out.println("Browser type is not supported!");
            }
        }
        webDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get().manage().window().maximize();
    }

}
