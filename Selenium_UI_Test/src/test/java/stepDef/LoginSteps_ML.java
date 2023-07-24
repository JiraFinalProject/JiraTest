package stepDef;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_object_model.LoginPO_ML;

public class LoginSteps_ML {
    private LoginPO_ML loginPO;

    @Given("I visit the landing page")
    public void iVisitTheLandingPage() {
        DriverFactory.getDriver().navigate().to("http://localhost:8080/login.jsp");
        loginPO = new LoginPO_ML();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsernameAdmin(String username) {
        loginPO.enterUsername(username);
    }


    @And("I enter the password {string}")
    public void iEnterThePasswordAdmin(String password) {
        loginPO.enterPassword(password);
    }


    @And("I click the login button on the login page")
    public void iClickTheLoginButton() {
        loginPO.clickLoginButton();
    }
}
