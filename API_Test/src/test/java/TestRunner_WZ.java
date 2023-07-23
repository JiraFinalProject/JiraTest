
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:stepDef"//,
        //plugin = { "pretty", "html:target/cucumber-report/report.html" },
        //monochrome = true
)
public class TestRunner_WZ extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
