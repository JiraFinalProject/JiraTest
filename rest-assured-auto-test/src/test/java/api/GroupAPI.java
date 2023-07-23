package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApplicationProperties;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GroupAPI {
    private final RequestSpecification requestSpec;

    public GroupAPI() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(ApplicationProperties.get("baseURI") + "/rest/api/2/group")
                .setContentType(ContentType.JSON)
                .build();
    }

    public Response addUserToGroup(String username, String groupName) {
        HashMap<String, String> name = new HashMap<>();
        name.put("name", username);
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .queryParam("groupname", groupName)
                .body(name)
                .when()
                .post("/user");
    }

    public Response applyGroupFilterAndIncludeInactiveUsers(String groupName) {
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .queryParam("groupname", groupName)
                .queryParam("includeInactiveUsers", true)
                .when()
                .get("/member");
    }
}
