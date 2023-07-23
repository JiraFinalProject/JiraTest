package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprintStepDef {
    private static final String BASEURL = "http://localhost:8080";
    private static final String BOARDNAME = "FIN board";
    private static final String PROJECTKEY = "FIN";
    private static final String ACTIVE = "active";

    private static ThreadLocal<Map<String, String>> variablesThreadLocal = new ThreadLocal<>();


    @When("As a team leader user, I can create and start a new sprint. {string} and {string}")
    public void asATeamLeaderUserICanCreateAndStartANewSprint(String tlUsername, String tlPassword) {
        // Get BoardId
        variablesThreadLocal.set(new HashMap<>());
        RestAssured.authentication = RestAssured.preemptive().basic(tlUsername, tlPassword);
        Response response =RestAssured.given().when().get(BASEURL+"/rest/agile/1.0/board");
        List<Map<String, Object>> boards = response.jsonPath().getList("values");
        String boardId = boards.stream()
                .filter(board -> board.get("name").equals(BOARDNAME))
                .findFirst()
                .map(board -> board.get("id").toString())
                .orElse(null);
        Map<String, String> variables = variablesThreadLocal.get();
        variables.put("boardId",boardId);
        //Create a Sprint
        JSONObject sprintBody = new JSONObject();
        sprintBody.put("endDate", "26/Jul/23 10:51 PM");
        sprintBody.put("goal", "test");
        sprintBody.put("name", "FIN Sprint 1");
        sprintBody.put("startDate", "19/Jul/23 10:51 PM");
        response= RestAssured.given()
                .contentType(ContentType.JSON)
                .body(sprintBody.toString())
                .when()
                .post(BASEURL+"/rest/greenhopper/1.0/sprint/"+boardId);
        response.then().log();


        //get Sprint id
        String sprintId = response.jsonPath().getString("id");
        variables.put("sprintId",sprintId);

        //create a issue for Sprint
        String sprintIssue ="{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"id\": \"10000\"\n" +
                "    },\n" +
                "    \"summary\": \"issue for sprint\",\n" +
                "    \"issuetype\": {\n" +
                "      \"id\": \"10001\"\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "      \"id\": \"2\"\n" +
                "    },\n" +
                "    \"customfield_10100\": "+sprintId+"\n" +
                "  }\n" +
                "}";
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(sprintIssue)
                .when()
                .post(BASEURL+"/rest/api/2/issue");

        JSONObject startBody = new JSONObject();
        startBody.put("endDate", "26/Jul/23 10:51 PM");
        startBody.put("goal", "test");
        startBody.put("name", "Active FIN Sprint");
        startBody.put("startDate", "19/Jul/23 10:51 PM");
        startBody.put("rapidViewId", boardId);
        startBody.put("sprintId", Integer.parseInt(sprintId));
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(startBody.toString())
                .when()
                .put(BASEURL+"/rest/greenhopper/1.0/sprint/"+sprintId+"/start");
    }

    @And("As a team leader user, I can move issues from the backlog to the current sprint. {string} and {string}")
    public void asATeamLeaderUserICanMoveIssuesFromTheBacklogToTheCurrentSprint(String tlUsername, String tlPassword) {
        RestAssured.authentication = RestAssured.preemptive().basic(tlUsername, tlPassword);

        //Create a Issue for Backlog
        String backlogIssue ="{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"id\": \"10000\"\n" +
                "        },\n" +
                "        \"summary\": \"issue for backlog\",\n" +
                "        \"issuetype\": {\n" +
                "            \"id\": \"10001\"\n" +
                "        },\n" +
                "        \"priority\": {\n" +
                "            \"id\": \"2\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(backlogIssue)
                .when()
                .post(BASEURL+"/rest/api/2/issue");

        Map<String, String> variables = variablesThreadLocal.get();
        String issueKey= response.jsonPath().getString("key");
        variables.put("issueKey",issueKey);
        String sprintId = variables.get("sprintId");
        //move
        String sprintIssue ="{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"id\": \"10000\"\n" +
                "    },\n" +
                "    \"summary\": \"issue for sprint\",\n" +
                "    \"issuetype\": {\n" +
                "      \"id\": \"10001\"\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "      \"id\": \"2\"\n" +
                "    },\n" +
                "    \"customfield_10100\": "+sprintId+"\n" +
                "  }\n" +
                "}";
        response=RestAssured.given()
                .contentType(ContentType.JSON)
                .body(sprintIssue)
                .when()
                .put(BASEURL+"/rest/api/2/issue/"+issueKey);


    }

    @When("As a developer user, I can view all the issues in the current sprint. {string} and {string}")
    public void asADeveloperUserICanViewAllTheIssuesInTheCurrentSprint(String deUsername, String dePassword) {
        RestAssured.authentication = RestAssured.preemptive().basic(deUsername, dePassword);
        Map<String, String> variables = variablesThreadLocal.get();
        RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("rapidViewId",variables.get("boardId"))
                .queryParam("selectedProjectKey",PROJECTKEY)
                .when()
                .get(BASEURL+"/rest/greenhopper/1.0/xboard/work/allData.json")
                .then().log();
    }

    @When("As a team lead user, I can end the current active sprint. {string} and {string}")
    public void asATeamLeadUserICanEndTheCurrentActiveSprint(String tlUsername, String tlPassword) {
        RestAssured.authentication = RestAssured.preemptive().basic(tlUsername, tlPassword);

        String boardId = variablesThreadLocal.get().get("boardId");
        //get active sprint
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/rest/agile/1.0/board/"+boardId+"/sprint");

        List<Map<String, Object>> sprints = response.jsonPath().getList("values");
        String activeSprintId = sprints.stream()
                .filter(sprint -> sprint.get("state").equals(ACTIVE))
                .findFirst()
                .map(board -> board.get("id").toString())
                .orElse(null);

        //end the sprint
        JSONObject requestBody = new JSONObject();
        requestBody.put("rapidViewId",boardId);
        requestBody.put("sprintId",activeSprintId);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .put("/rest/greenhopper/1.0/sprint/"+activeSprintId+"/complete");

    }


}
