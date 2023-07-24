package stepDef;

import entity.Project_ML;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProjectStepDef_ML {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Integer> projectIdThreadLocal = new ThreadLocal<>();
    static final String username_ML = "Junyu Deng";
    static final String password_ML = "12345678";

    @When("as an admin user, I create a scrum project with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and apply an existing permission scheme {int}")
    public void iCreateAScrumProjectAsAnAdminUser(String projectKey, String projectName, String projectTypeKey, String projectTemplateKey,
                                                  String description, String lead, String url, String assigneeType, int permissionScheme) {

        Project_ML newProject = Project_ML.builder()
                .key(projectKey)
                .name(projectName)
                .projectTypeKey(projectTypeKey)
                .projectTemplateKey(projectTemplateKey)
                .description(description)
                .lead(lead)
                .url(url)
                .assigneeType(assigneeType)
                .permissionScheme(permissionScheme)
                .build();

        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .body(newProject)
                .post("http://localhost:8080/rest/api/2/project");

        projectIdThreadLocal.set(response.jsonPath().get("id"));
        responseThreadLocal.set(response);
//        response.then().log().body();
    }

    @And("as an admin user, I add user {int} to the current project {string}")
    public void iAddUserUsernameToTheCurrentProjectAsAnAdminUser(int userAccountId, String projectKey) {
        String userKey = UserStepDef_ML.userKeyThreadLocal.get();
        HashMap<String, String[]> userDetail = new HashMap<>();
        userDetail.put("groups", new String[]{});
        userDetail.put("users", new String[]{userKey});

        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .pathParam("projectKey", projectKey)
                .pathParam("userId", userAccountId)
                .contentType(ContentType.JSON)
                .body(userDetail)
                .when()
                .post("http://localhost:8080/rest/projectconfig/latest/roles/{projectKey}/{userId}");
        responseThreadLocal.set(response);
//        response.then().log().body();
    }

    @And("as a team lead user, I can create different epics such as {string}, {string}, {string}, {string}")
    public void iCanCreateAEpicsAsATeamLeadUser(String epicName1, String epicName2, String epicName3, String epicName4) {
        Response response = createEpicByName(epicName1, projectIdThreadLocal.get());
//        response.then().log().body();
        createEpicByName(epicName2, projectIdThreadLocal.get());
        createEpicByName(epicName3, projectIdThreadLocal.get());
        createEpicByName(epicName4, projectIdThreadLocal.get());
    }

    private Response createEpicByName(String epicName, int projectId) {
        String summary = "this is " + epicName + " epic";

        String requestBody = "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"id\": \"" + projectId + "\"\n" +
                "        },\n" +
                "        \"summary\": \"" + summary + "\",\n" +
                "        \"issuetype\": {\n" +
                "            \"id\": \"10000\"\n" +
                "        },\n" +
                "        \"customfield_10104\": \"" + epicName + "\"\n" +
                "    }\n" +
                "}";

        Response response = given()
                .auth()
                .preemptive()
                .basic(username_ML, password_ML)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:8080/rest/api/2/issue")
                ;
        //response.then().log().body();
        return response;
    }//since team lead was assigned to the admin user, we use the same credentials
}
