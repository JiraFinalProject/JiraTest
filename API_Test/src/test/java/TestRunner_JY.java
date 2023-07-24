
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//import io.cucumber.junit.jupiter.Cucumber;
//import io.cucumber.junit.jupiter.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "classpath:stepDef",
        tags = "@Workflow",
        publish = true
)
@RunWith(Cucumber.class)
public class TestRunner_JY
{

}
