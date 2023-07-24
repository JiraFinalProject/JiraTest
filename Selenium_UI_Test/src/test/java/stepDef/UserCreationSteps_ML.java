package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page_object_model.UserCreationPO_ML;

public class UserCreationSteps_ML {
    private final UserCreationPO_ML userCreationPO = new UserCreationPO_ML();

    @When("I enter email address {string}, full name {string}, username {string}, password {string}")
    public void iEnterEmailAddressEmailAddressFullNameDisplayNameUsernameNamePasswordPassword(String emailAddress, String displayName, String name, String password) {
        userCreationPO.enterEmailAddress(emailAddress);
        userCreationPO.enterFullName(displayName);
        userCreationPO.enterUserName(name);
        userCreationPO.enterPassword(password);
    }

    @And("I click create user button on the user creation page")
    public void iClickCreateUserButtonOnTheUserCreationPage() {
        userCreationPO.clickCreateUserBtn();
    }
}
