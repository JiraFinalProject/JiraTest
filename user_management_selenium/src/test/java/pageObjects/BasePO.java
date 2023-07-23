package pageObjects;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePO {
    public BasePO() {
        WebDriver driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

}
