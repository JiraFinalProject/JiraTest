package runners;

import drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:stepDef",
        tags = "@projectManagement"
)
public class TestRunner extends AbstractTestNGCucumberTests {
//    @AfterTest
//    public void quitBrowser() {
//        DriverFactory.getDriver().quit();
//    }
}
