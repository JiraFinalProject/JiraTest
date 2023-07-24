package stepDef;

import entity.User_ML;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class UserStepDef_ML {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> userKeyThreadLocal = new ThreadLocal<>();
    static final String username_ML = "Junyu Deng";
    static final String password_ML = "12345678";
    @When("I create a user with {string}, {string}, {string}, {string}, and {string} as an admin user")
    public void asAAdminICreateAUserWithNamePasswordEmailAddressDisplayNameAndApplicationKeys(String name, String password, String emailAddress, String displayName, String applicationKeys) {
//        applicationKeys: ["jira-core"]
        User_ML newUser = User_ML.builder()
                .name(name)
                .password(password)
                .emailAddress(emailAddress)
                .displayName(displayName)
                .applicationKeys(new String[]{applicationKeys})
                .build();
        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .body(newUser)
                .post("http://localhost:8080/rest/api/2/user");
        responseThreadLocal.set(response);
        userKeyThreadLocal.set(response.jsonPath().get("key"));
//        response.then().log().body();
    }

    @And("I deactivate a user {string}")
    public void iDeactivateAUser(String username) {
        HashMap<String, Boolean> status = new HashMap<>();
        status.put("active", false);
        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .queryParam("username", username)
                .body(status)
                .when()
                .put("http://localhost:8080/rest/api/2/user");
        responseThreadLocal.set(response);
    }

    @And("I apply the user status filter on user {string}")
    public void iApplyTheUserStatusFilter(String username) {
        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .queryParam("username", username)
                .queryParam("includeInactive", true)
                .queryParam("includeActive", false)
                .when()
                .get("http://localhost:8080/rest/api/2/user/search");
        responseThreadLocal.set(response);
    }

    @Then("I should view the user {string} in the deactivated users result set")
    public void iShouldViewTheUserInTheDeactivatedUsersResultSet(String username) {
//        responseThreadLocal.get().then().log().body();
        assertEquals(username, responseThreadLocal.get().jsonPath().get("[0].name"));
    }
}
