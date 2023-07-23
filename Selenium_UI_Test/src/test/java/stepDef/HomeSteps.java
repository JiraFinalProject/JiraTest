package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.HomePO;
import page_object_model.LoginPO;

public class HomeSteps {
    private final HomePO homePO;
    private final WebDriver driver;

    public HomeSteps() {
        homePO = new HomePO();
        driver = DriverFactory.getDriver();
    }

    @When("I click setting button")
    public void i_enter_home_setting() {
        homePO.clickSettingBtn();
    }
    @And("I click system menu")
    public void i_click_system_button() {
        homePO.gotoSystem();
    }

    @And("I enter {string}")
    public void i_enter_password(String password) {
        homePO.enterPassword(password);
    }

    @Then("I click confirm")
    public void i_click_confirm() {
        homePO.clickConfirmButton();
    }
}
