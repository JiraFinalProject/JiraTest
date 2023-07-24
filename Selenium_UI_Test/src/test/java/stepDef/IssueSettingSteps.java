package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.IssueSettingPO;

public class IssueSettingSteps {
    private final IssueSettingPO issueSettingPO;
    private final WebDriver driver;

    public IssueSettingSteps() {
        issueSettingPO = new IssueSettingPO();
        driver = DriverFactory.getDriver();
    }

    @When("I open issue setting")
    public void i_open_issue_setting() {
        issueSettingPO.goToPermissionScheme();
    }

    @Then("I create permission scheme")
    public void i_create_scheme() throws InterruptedException {
        issueSettingPO.addPermissionScheme();
        issueSettingPO.editScheme();
        issueSettingPO.assignScheme();
    }

}
