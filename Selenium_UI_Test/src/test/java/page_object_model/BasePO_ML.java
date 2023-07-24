package page_object_model;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePO_ML {
    public BasePO_ML() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}