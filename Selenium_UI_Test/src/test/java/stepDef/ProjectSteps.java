package stepDef;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.LoginPO;
import page_object_model.ProjectPO;
import page_object_model.SettingPO;
public class ProjectSteps {
    private final ProjectPO projectPO;
    private final WebDriver driver;

    public ProjectSteps() {
        projectPO = new ProjectPO();
        driver = DriverFactory.getDriver();
    }

    @Then("I manage project role and assign user and filter by role")
    public void i_set_project_roles() throws InterruptedException {
        projectPO.setProjectButton();
        projectPO.setProjectUserBox();
        projectPO.setFilterButton();
    }
}
