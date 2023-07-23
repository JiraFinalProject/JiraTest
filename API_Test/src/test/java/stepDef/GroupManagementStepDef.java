package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

public class GroupManagementStepDef {

    ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();

    @Given("I am an admin user with {string} and {string}")
    public void iAmAnAdminUser(String username, String password) {
        // Set the authentication on RestAssured
        RestAssured.authentication = RestAssured.preemptive().basic(username, password);;
        RestAssured.baseURI = "http://localhost:8080";
    }

    @When("I create group {string}")
    public void iCreateGroup(String groupName) {
        String requestBody = "{\"name\":\"" + groupName + "\"}";
        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/rest/api/2/group"));
    }

    @Then("the group {string} is successfully created")
    public void theGroupIsSuccessfullyCreated(String groupName) {
        Response response = responseThreadLocal.get();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 201);
        softAssert.assertEquals(response.jsonPath().getString("name"), groupName);
        softAssert.assertAll();
    }

    @When("I assign an existing user {string} to the newly created group {string}")
    public void iAssignExistingUsersToDifferentGroups(String username, String groupName) {
        String requestBody = "{\"name\":\"" + username + "\"}";
        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .queryParam("groupname", groupName)
                .when()
                .post("/rest/api/2/group/user"));
    }

    @Then("the assign is successfully performed")
    public void theAssignIsSuccessfullyPerformed() {
        Response response = responseThreadLocal.get();
        Assert.assertEquals(response.statusCode(), 201);
    }

    @And("I can filter user {string} based on the group {string}")
    public void iCanFilterUserBasedOnTheGroupGroupName(String username, String groupName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("groupname", groupName)
                .when()
                .get("/rest/api/2/group/member");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.jsonPath().getString("values[0].name"), username);
        softAssert.assertAll();
    }
}
