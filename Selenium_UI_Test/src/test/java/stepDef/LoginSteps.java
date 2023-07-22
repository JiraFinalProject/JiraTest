package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.LoginPO;

public class LoginSteps {
    private final LoginPO loginPO;
    private final WebDriver driver;

    public LoginSteps() {
        loginPO = new LoginPO();
        driver = DriverFactory.getDriver();
    }


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.navigate().to("http://localhost:8080/login.jsp");
    }
    @When("I enter {string} and {string}")
    public void i_enter_the_valid_credential(String username, String password) {
        loginPO.enterUserName(username);
        loginPO.enterPassword(password);
    }
    @Then("I click login button")
    public void i_click_login_button() {
        loginPO.clickLoginBtn();
    }


}
