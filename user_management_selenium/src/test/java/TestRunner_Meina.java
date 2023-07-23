import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "classpath:stepDef",
        tags = "@projectManagement"
)
// tags = {@userManagement, @projectManagement}

public class TestRunner_Meina extends AbstractTestNGCucumberTests {
//    @AfterTest
//    public void quitBrowser() {
//        DriverFactory.getDriver().quit();
//    }
}
