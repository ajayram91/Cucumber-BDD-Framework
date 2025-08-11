package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiUtils {
    public static Response loginAndGetResponse(String username, String password) {
        // Base URL for API
        RestAssured.baseURI = "http://crater.primetech-apps.com/api/v1/auth";

        // Login request body
        String loginPayload = "{\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"device_name\": \"mobile_app\"\n" +
                "}";
        // Send POST request and return the Response object
        Response response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("/login") // Adjust endpoint if needed
                .then()
                .extract()
                .response();

        System.out.println("Login Status: " + response.getStatusCode());
        System.out.println("Login Body: " + response.asString());
        return response;
    }

}
