package api;

import entity.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApplicationProperties;


import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserAPI {
    private final RequestSpecification requestSpec;

    public UserAPI() {
        this.requestSpec = new RequestSpecBuilder()
                .setBaseUri(ApplicationProperties.get("baseURI") + "/rest/api/2/user")
                .setContentType(ContentType.JSON)
                .build();
    }
    public Response createUser(User newUser) {
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .body(newUser)
                .post();
    }

    public Response deactivateAUserByName(String username) {
        HashMap<String, Boolean> status = new HashMap<>();
        status.put("active", false);
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .queryParam("username", username)
                .body(status)
                .when()
                .put();
    }

    public Response applyFilterByNameAndInactiveStatus(String username) {
        return given(requestSpec)
                .auth()
                .preemptive()
                .basic(ApplicationProperties.get("adminUsername"), ApplicationProperties.get("adminPassword"))
                .queryParam("username", username)
                .queryParam("includeInactive", true)
                .queryParam("includeActive", false)
                .when()
                .get("/search");
    }
}
