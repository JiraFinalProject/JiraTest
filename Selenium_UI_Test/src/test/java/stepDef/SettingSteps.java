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
import page_object_model.SettingPO;

public class SettingSteps {
    private final SettingPO settingPO;
    private final WebDriver driver;

    public SettingSteps() {
        settingPO = new SettingPO();
        driver = DriverFactory.getDriver();
    }
    @When("I click project role setting")
    public void i_click_project_role() {
        settingPO.clickProjectRoleButton();
    }
    @And("I create lead role with {string} and {string}")
    public void i_enter_lead_description(String roleName, String roleDescript) {
        settingPO.enterRoleName(roleName);
        settingPO.enterRoleDescript(roleDescript);
    }

    @Then("I click add lead role button")
    public void i_click_add_role_lead() {
        settingPO.clickAddRole();
    }
    @And("I create qa role with {string} and {string}")
    public void i_enter_qa_name_description(String roleName, String roleDescript) {
        settingPO.enterRoleName(roleName);
        settingPO.enterRoleDescript(roleDescript);
    }

    @Then("I click add qa role button")
    public void i_click_add_qa_role() {
        settingPO.clickAddRole();
    }
    @And("I create dev role with {string} and {string}")
    public void i_enter_dev_name_description(String roleName, String roleDescript) {
        settingPO.enterRoleName(roleName);
        settingPO.enterRoleDescript(roleDescript);
    }

    @Then("I click add dev role button")
    public void i_click_add_dev_role() {
        settingPO.clickAddRole();
    }

    @When("I manage member of a developer role")
    public void i_click_manage_member() {
        settingPO.clickManageMember();
        settingPO.setEditLink();
    }

    @And("I add user to dev role")
    public void i_add_user_to_role() {
        settingPO.setAddUsernameBox();
    }


}
