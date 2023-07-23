package stepDef;

import api.GroupAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;


public class GroupStepDefs {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    @When("I add a user {string} to a group {string}")
    public void iAssignedAUserToAGroupGroupName(String name, String groupName) {
        Response response = new GroupAPI()
                .addUserToGroup(name, groupName);
        responseThreadLocal.set(response);
    }

    @And("I apply the group filter {string}")
    public void iApplyTheGroupFilterGroupName(String groupName) {
        Response response = new GroupAPI()
                .applyGroupFilterAndIncludeInactiveUsers(groupName);
//        response.then().log().body();
        responseThreadLocal.set(response);
    }

    @Then("I should view the user {string} in the result set")
    public void iShouldViewTheUserInTheResultSet(String username) {
        assertEquals(true, responseThreadLocal.get().jsonPath().getList("values.name").contains(username));
    }
}
