package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateRoleStepDef {
    //private static final ThreadLocal<User> currenUser = new ThreadLocal<>();
    static private String BASEURL = "http://localhost:8080";
    static private String USERNAME = "Junyu Deng";
    static private String PASSWORD = "12345678";
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> teamID = new ThreadLocal<>();
    static ThreadLocal<String> devID = new ThreadLocal<>();
    static ThreadLocal<String> qaID = new ThreadLocal<>();
    @When("I log in as an admin user")
    public void loginAsAdmin() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", USERNAME);
        jsonObject.put("password", PASSWORD);
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post(baseURI + "/rest/auth/1/session")
                .then()
                .statusCode(200).log().body();

    }

    @Then("I can create team lead project roles")
    public void createTeamLead() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "team lead");
        jsonObject.put("description", "The leader of development team");
        Response responseTemp = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post(BASEURL + "/rest/api/2/role");
        teamID.set(responseTemp.jsonPath().getString("id"));
        responseTemp
                .then()
                .log().body();
    }

    @Then("I can create developer project roles")
    public void createDeveloper() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        JSONObject developer = new JSONObject();
        developer.put("name", "developer");
        developer.put("description", "Role for all developers");
        Response responseTemp = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(developer.toString())
                .post(BASEURL + "/rest/api/2/role");
        devID.set(responseTemp.jsonPath().getString("id"));
        responseTemp
                .then()
                .log().body();
    }

    @Then("I can create qa project roles")
    public void createQA() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        JSONObject qa = new JSONObject();
        qa.put("name", "QA");
        qa.put("description", "Role Quality Engineer");
        Response responseTemp = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(qa.toString())
                .post(BASEURL + "/rest/api/2/role");
        qaID.set(responseTemp.jsonPath().getString("id"));
        responseTemp
                .then()
                .log().body();
    }
    @When("I add existing user to a project role")
    public void addUserToRole() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        JSONObject jsonObject = new JSONObject();
        String[] users = new String[]{"developer"};
        jsonObject.put("user", users);
        responseThreadLocal.set(RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post(BASEURL + "/rest/api/2/project/10001/role/"+devID.get()));
    }

    @Then("I check the status code")
    public void checkStatusCode() {
        responseThreadLocal.get().then()
                .log().body();
    }

    @When("I filter users in a project based on their roles")
    public void filterUserByRole() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);

        responseThreadLocal.set(RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASEURL + "/rest/api/2/project/10001/role/"+devID.get()));
    }

    @Then("I print out all users")
    public void printUserByRole() {
        responseThreadLocal.get().then().log().body();
    }

    @When("I create the permission scheme")
    public void createPermissionScheme() throws IOException {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        String jsonString = "{\"name\":\"PermissionScheme\",\"description\":\"teamleadcanmanagesprints&assignissues;developercanresolveanissue;QAcancloseanissue\",\"permissions\":[{\"holder\":{\"type\":\"projectRole\",\"parameter\":"+teamID.get()+"},\"permission\":\"MANAGE_SPRINTS_PERMISSION\"},{\"holder\":{\"type\":\"projectRole\",\"parameter\":"+teamID.get()+"},\"permission\":\"ASSIGN_ISSUES\"},{\"holder\":{\"type\":\"projectRole\",\"parameter\":"+devID.get()+"},\"permission\":\"RESOLVE_ISSUES\"},{\"holder\":{\"type\":\"projectRole\",\"parameter\":"+qaID.get()+"},\"permission\":\"CLOSE_ISSUES\"}]}";
        responseThreadLocal.set(RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonString)
                .post(BASEURL + "/rest/api/2/permissionscheme"));
    }

    @Then("I get all permission scheme to validate")
    public void getAllPermissionScheme() {
        responseThreadLocal.get().then().log().body();

        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASEURL + "/rest/api/2/permissionscheme").then().log().body();
    }
    @When("I assign the scheme to project")
    public void assignToProject() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", responseThreadLocal.get().jsonPath().getString("id"));
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .put(BASEURL + "/rest/api/2/project/10001/permissionscheme").then().log().body();

    }

    @Then("I get the scheme of the project")
    public void getSchemeOfProject() {
        RestAssured.authentication = RestAssured.preemptive().basic(USERNAME, PASSWORD);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASEURL + "/rest/api/2/project/10001/permissionscheme").then().log().body();
    }

}
