package stepDef;

import api.GroupAPI;
import api.ProjectAPI;
import entity.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ProjectStepDefs {
    static ThreadLocal<Response> responseThreadLocal = new ThreadLocal<>();
    static ThreadLocal<Integer> projectIdThreadLocal = new ThreadLocal<>();


    @When("as an admin user, I create a scrum project with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and apply an existing permission scheme {int}")
    public void iCreateAScrumProjectAsAnAdminUser(String projectKey, String projectName, String projectTypeKey, String projectTemplateKey,
                                                  String description, String lead, String url, String assigneeType, int permissionScheme) {
        Response response = new ProjectAPI()
                .createProject(Project.builder()
                        .key(projectKey)
                        .name(projectName)
                        .projectTypeKey(projectTypeKey)
                        .projectTemplateKey(projectTemplateKey)
                        .description(description)
                        .lead(lead)
                        .url(url)
                        .assigneeType(assigneeType)
                        .permissionScheme(permissionScheme)
                        .build());
        projectIdThreadLocal.set(response.jsonPath().get("id"));
        responseThreadLocal.set(response);
//        response.then().log().body();
    }

    @And("as an admin user, I add user {int} to the current project {string}")
    public void iAddUserUsernameToTheCurrentProjectAsAnAdminUser(int userAccountId, String projectKey) {
        Response response = new ProjectAPI()
                .addUserToProject(UserStepDefs.userKeyThreadLocal.get(), userAccountId, projectKey);
        responseThreadLocal.set(response);
//        response.then().log().body();
    }

    @And("as a team lead user, I can create different epics such as {string}, {string}, {string}, {string}")
    public void iCanCreateAEpicsAsATeamLeadUser(String epicName1, String epicName2, String epicName3, String epicName4) {
        Response response = new ProjectAPI().createEpicByName(epicName1, projectIdThreadLocal.get());
//        response.then().log().body();
        new ProjectAPI().createEpicByName(epicName2, projectIdThreadLocal.get());
        new ProjectAPI().createEpicByName(epicName3, projectIdThreadLocal.get());
        new ProjectAPI().createEpicByName(epicName4, projectIdThreadLocal.get());
    }
}
