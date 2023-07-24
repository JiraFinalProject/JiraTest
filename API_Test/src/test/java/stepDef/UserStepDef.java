package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserStepDef {
    //private static final ThreadLocal<User> currenUser = new ThreadLocal<>();

    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
//    @When("I log in as an admin user")
//    public void loginAsAdmin() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username", "Junyu Deng");
//        jsonObject.put("password", "12345678");
//        given()
//                        .contentType(ContentType.JSON)
//                .when()
//                .body(jsonObject.toString())
//                .post("http://localhost:8080/rest/auth/1/session")
//                .then()
//                .statusCode(200).log().body();
//
//    }
//
//    @Then("I can create three project roles team lead, developer, QA")
//    public void createRoles() {
//        ;
//
//    }
    static final String username_JY = "Junyu Deng";
    static final String password_JY = "12345678";
    @When("I am a developer")
    public void loginAsDeveloper(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username_JY);
        jsonObject.put("password", password_JY);
        given().contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post("http://localhost:8080/rest/auth/1/session")
                .then()
                .statusCode(200).log().body();

    }
    @Then("I can move issues from To Do to In Progress")
    public void fromToDoToInProgress(){

           given().auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .header("Content-Type", "application/json")
                .body("{\"transition\": {\"id\":\"21\"}}")
                .when()
                .post("http://localhost:8080/rest/api/2/issue/FP-11/transitions")
                .then()
                .statusCode(204);

        String status = given()
                .auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .when()
                .get("http://localhost:8080/rest/api/2/issue/FP-11")
                .then()
                .statusCode(200)
                .extract()
                .path("fields.status.name");

        assertEquals("In Progress", status);



    }

    @Then("I can move issues from In Progress to Resolved")
    public void fromInProgressToResolved(){

                given().auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .header("Content-Type", "application/json")
                .body("{\"transition\": {\"id\":\"41\"}}")
                .when()
                .post("http://localhost:8080/rest/api/2/issue/FP-11/transitions")
                .then()
                .statusCode(204);

        String status = given()
                .auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .when()
                .get("http://localhost:8080/rest/api/2/issue/FP-11")
                .then()
                .statusCode(200)
                .extract()
                .path("fields.status.name");

        assertEquals("Resolved", status);






    }
    @When("I am a QA")
    public void loginAsQA(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username_JY);
        jsonObject.put("password", password_JY);
        given().contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .post("http://localhost:8080/rest/auth/1/session")
                .then()
                .statusCode(200).log().body();

    }


    @Then("I can move issues from Resolved to Closed")
    public void fromResolvedToClosed(){

                given().auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .header("Content-Type", "application/json")
                .body("{\"transition\": {\"id\":\"51\"}}")
                .when()
                .post("http://localhost:8080/rest/api/2/issue/FP-11/transitions")
                .then()
                .statusCode(204);

        String status = given()
                .auth()
                .preemptive()
                .basic(username_JY, password_JY)
                .when()
                .get("http://localhost:8080/rest/api/2/issue/FP-11")
                .then()
                .statusCode(200)
                .extract()
                .path("fields.status.name");

        assertEquals("Closed", status);



    }
}
