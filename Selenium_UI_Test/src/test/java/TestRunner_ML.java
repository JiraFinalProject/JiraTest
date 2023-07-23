import drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:stepDef",
        tags = "@projectManagement"
)
// tags = {@userManagement, @projectManagement}

public class TestRunner_ML extends AbstractTestNGCucumberTests {
    private long startTime;

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass(ITestContext context) {
        this.startTime = System.currentTimeMillis();
        super.setUpClass(context);
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDownClass() {
        long executionTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Total Execution Time: " + executionTime + " seconds");
//        DriverFactory.teardown();
    }
}
