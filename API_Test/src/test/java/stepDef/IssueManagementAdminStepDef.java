package stepDef;

import entity.IssueRequest;
import entity.LinkIssueRequest;
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

public class IssueManagementAdminStepDef {

    private ThreadLocal<Response>  responseThreadLocal = new ThreadLocal<>();
    private ThreadLocal<String> epicKeyThreadLocal = new ThreadLocal<>();
    private ThreadLocal<String> blockingIssueThreadLocal = new ThreadLocal<>();
    private ThreadLocal<String> newIssueThreadLocal = new ThreadLocal<>();
    private ThreadLocal<String> commentThreadLocal = new ThreadLocal<>();

    @When("Create an epic")
    public void createAnEpic() {
        IssueRequest newEpic = IssueRequest.builder()
                        .fields(IssueRequest.Fields.builder()
                                .summary("Frontend Development")
                                .project(IssueRequest.CustomField.builder().id("10000").build())
                                .issuetype(IssueRequest.CustomField.builder().id("10000").build())
                                .priority(IssueRequest.CustomField.builder().id("2").build())
                                .epicName("Epic-1")
                                .build())
                        .build();

        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .body(newEpic)
                .when()
                .post("/rest/api/2/issue"));
    }

    @Then("the epic is successfully created")
    public void theEpicIsSuccessfullyCreated() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 201);
    }

    @And("store the key to this epic")
    public void storeTheKeyToThisEpic() {
        epicKeyThreadLocal.set(responseThreadLocal.get().jsonPath().getString("key"));
    }

    @When("Create a blocking issue")
    public void createABlockingIssue() {
        IssueRequest newIssue = IssueRequest
                .builder()
                .fields(IssueRequest.Fields
                        .builder()
                            .summary("The blocking issue")
                            .project(IssueRequest.CustomField.builder().id("10000").build())
                            .issuetype(IssueRequest.CustomField.builder().id("10001").build())
                            .priority(IssueRequest.CustomField.builder().id("2").build())
                        .build())
                .build();

        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .body(newIssue)
                .when()
                .post("/rest/api/2/issue"));
    }

    @Then("the issue is successfully created")
    public void theIssueIsSuccessfullyCreated() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 201);
    }

    @And("store the blocking issue")
    public void storeTheBlockingIssue() {
        blockingIssueThreadLocal.set(responseThreadLocal.get().jsonPath().getString("key"));
    }

    @When("I create an issue with priority {string} and epic link to the epic created before")
    public void iCreateAnIssueWithPriorityAndEpicLinkToTheEpicCreatedBefore(String priority) {
        IssueRequest newIssue = IssueRequest.builder()
                .fields(IssueRequest.Fields.builder()
                        .summary("The issue with priority " + priority + " and link to the epic " + epicKeyThreadLocal.get())
                        .project(IssueRequest.CustomField.builder().id("10000").build())
                        .issuetype(IssueRequest.CustomField.builder().id("10001").build())
                        .priority(IssueRequest.CustomField.builder().id(priority).build())
                        .epicLink(epicKeyThreadLocal.get())
                        .build())
                .build();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(newIssue)
                .when()
                .post("/rest/api/2/issue");
        responseThreadLocal.set(response);
        newIssueThreadLocal.set(response.jsonPath().getString("key"));
    }

    @When("I specify that the new issue is blocked by the blocking issues")
    public void iSpecifyThatTheNewIssueIsBlockedByTheBlockingIssues() {
        LinkIssueRequest linkIssueRequest = LinkIssueRequest.builder()
                    .type(LinkIssueRequest.Type.builder().id("10000").name("blocks").build())
                    .inwardIssue(LinkIssueRequest.Issue.builder().key(blockingIssueThreadLocal.get()).build())
                    .outwardIssue(LinkIssueRequest.Issue.builder().key(newIssueThreadLocal.get()).build())
                .build();
        Response response = given()
                .contentType(ContentType.JSON)
                .body(linkIssueRequest)
                .when()
                .post("/rest/api/2/issueLink");
        responseThreadLocal.set(response);
    }

    @Then("the dependency is set successfully")
    public void theDependencyIsSetSuccessfully() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 201);
    }

    @When("I assign the new issue to the user {string}")
    public void iAssignTheCurrentIssueToAUser(String assignee) {
        String requestBody = "{\"name\":\"" + assignee + "\"}";
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("issueKey", newIssueThreadLocal.get())
                .body(requestBody)
                .when()
                .put("/rest/api/2/issue/{issueKey}/assignee");
        responseThreadLocal.set(response);
        responseThreadLocal.get().then().log().body();
    }

    @Then("the assign is successfully created")
    public void theIssueIsAssignedToTheSpecifiedUser() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 204);
    }

    @Given("I am a developer user with {string} and {string}")
    public void iAmADeveloperUserWithAnd(String username, String password) {
        RestAssured.authentication = RestAssured.preemptive().basic(username, password);;
    }

    @When("I view all the issues assigned to me {string}")
    public void iFilterTheIssuesBasedOnTheUser(String username) {
        responseThreadLocal.set(given()
                .queryParam("jql", "assignee=" + username)
                .when()
                .get("/rest/api/2/search"));
    }

    @Then("view all my issues successfully")
    public void viewAllMyIssuesSuccessfully() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 200);
    }

    @When("I add a comment {string} to the issue")
    public void iAddACommentToTheIssue(String comment) {
        String requestBody = "{\"body\":\"" + comment + "\"}";
        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .pathParam("issueKey", newIssueThreadLocal.get())
                .body(requestBody)
                .when()
                .post("/rest/api/2/issue/{issueKey}/comment"));
    }

    @Then("the comment is successfully created by me {string}")
    public void theCommentIsSuccessfullyCreated(String author) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseThreadLocal.get().statusCode(), 201);
        softAssert.assertEquals(responseThreadLocal.get().jsonPath().getString("author.name"), author);
        softAssert.assertAll();
    }

    @And("store the id of the comment")
    public void storeTheIdOfTheComment() {
        commentThreadLocal.set(responseThreadLocal.get().jsonPath().getString("id"));
    }

    @When("I edit the comment {string} of the issue")
    public void iEditTheCommentOfTheIssue(String comment) {
        String requestBody = "{\"body\":\"" + comment + "\"}";
        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .pathParam("issueKey", newIssueThreadLocal.get())
                .pathParam("commentId", commentThreadLocal.get())
                .body(requestBody)
                .when()
                .put("/rest/api/2/issue/{issueKey}/comment/{commentId}"));
    }

    @Then("the comment is successfully updated")
    public void theCommentIsSuccessfullyUpdated() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 200);
    }

    @When("I reply to the updated comment {string}")
    public void iReplyToTheUpdatedComment(String comment) {
        String requestBody = "{\n" +
                "    \"body\": \"" + comment + "\",\n" +
                "    \"parent\": {\n" +
                "        \"id\": \"" + commentThreadLocal.get() + "\"\n" +
                "    }\n" +
                "}";
        responseThreadLocal.set(given()
                .contentType(ContentType.JSON)
                .pathParam("issueKey", newIssueThreadLocal.get())
                .body(requestBody)
                .when()
                .post("/rest/api/2/issue/{issueKey}/comment"));
    }

    @Then("the reply is successfully created")
    public void theReplyIsSuccessfullyCreated() {
        Assert.assertEquals(responseThreadLocal.get().statusCode(), 201);
    }
}
