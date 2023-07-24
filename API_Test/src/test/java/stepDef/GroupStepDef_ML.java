package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class GroupStepDef_ML {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static final String username_ML = "Junyu Deng";
    static final String password_ML = "12345678";
    @When("I add a user {string} to a group {string}")
    public void iAssignedAUserToAGroupGroupName(String username, String groupName) {
        HashMap<String, String> name = new HashMap<>();
        name.put("name", username);

        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .queryParam("groupname", groupName)
                .body(name)
                .when()
                .post("http://localhost:8080/rest/api/2/group/user");
        responseThreadLocal.set(response);
    }

    @And("I apply the group filter {string}")
    public void iApplyTheGroupFilterGroupName(String groupName) {
        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .queryParam("groupname", groupName)
                .queryParam("includeInactiveUsers", true)
                .when()
                .get("http://localhost:8080/rest/api/2/group/member");
//        response.then().log().body();
        responseThreadLocal.set(response);
    }

    @Then("I should view the user {string} in the result set")
    public void iShouldViewTheUserInTheResultSet(String username) {
        assertEquals(true, responseThreadLocal.get().jsonPath().getList("values.name").contains(username));
    }
}
