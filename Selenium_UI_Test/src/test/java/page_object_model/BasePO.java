package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePO {
    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
