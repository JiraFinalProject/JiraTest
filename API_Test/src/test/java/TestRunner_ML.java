import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:stepDef",
        tags = "@userManagement"
)
//tags = {@userManagement, @projectManagement}
public class TestRunner_ML extends AbstractTestNGCucumberTests {
//    @DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
