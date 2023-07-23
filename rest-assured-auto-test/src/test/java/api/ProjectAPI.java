package api;

import entity.Project;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApplicationProperties;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProjectAPI {
    private final RequestSpecification requestSpec;

    public ProjectAPI() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(ApplicationProperties.get("baseURI"))
                .setContentType(ContentType.JSON)
                .build();
    }

    public Response createProject(Project newProject) {
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .body(newProject)
                .post("/rest/api/2/project");
    }

    public Response addUserToProject(String userKey, int userAccountId, String projectKey) {
        HashMap<String, String[]> userDetail = new HashMap<>();
        userDetail.put("groups", new String[]{});
        userDetail.put("users", new String[]{userKey});

        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .pathParam("projectKey", projectKey)
                .pathParam("userId", userAccountId)
                .body(userDetail)
                .when()
                .post("/rest/projectconfig/latest/roles/{projectKey}/{userId}");
    }

    public Response createEpicByName(String epicName, int projectId) {
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

        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .body(requestBody)
                .when()
                .post("/rest/api/2/issue");
    }//since team lead was assigned to the admin user, we use the same credentials
}
