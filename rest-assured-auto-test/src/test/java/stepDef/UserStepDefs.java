package stepDef;

import api.UserAPI;
import entity.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;


public class UserStepDefs {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> userKeyThreadLocal = new ThreadLocal<>();

    @When("I create a user with {string}, {string}, {string}, {string}, and {string} as an admin user")
    public void asAAdminICreateAUserWithNamePasswordEmailAddressDisplayNameAndApplicationKeys(String name, String password, String emailAddress, String displayName, String applicationKeys) {
//        applicationKeys: ["jira-core"]
        Response response = new UserAPI()
                .createUser(User.builder()
                        .name(name)
                        .password(password)
                        .emailAddress(emailAddress)
                        .displayName(displayName)
                        .applicationKeys(new String[]{applicationKeys})
                        .build());
        responseThreadLocal.set(response);
        userKeyThreadLocal.set(response.jsonPath().get("key"));
//        response.then().log().body();
    }

    @And("I deactivate a user {string}")
    public void iDeactivateAUser(String username) {
        Response response = new UserAPI()
                .deactivateAUserByName(username);
        responseThreadLocal.set(response);
    }

    @And("I apply the user status filter on user {string}")
    public void iApplyTheUserStatusFilter(String username) {
        Response response = new UserAPI()
                .applyFilterByNameAndInactiveStatus(username);
        responseThreadLocal.set(response);
    }

    @Then("I should view the user {string} in the deactivated users result set")
    public void iShouldViewTheUserInTheDeactivatedUsersResultSet(String username) {
//        responseThreadLocal.get().then().log().body();
        assertEquals(username, responseThreadLocal.get().jsonPath().get("[0].name"));
    }
}
