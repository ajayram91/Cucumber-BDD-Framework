package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ApiUtils;

import static io.restassured.RestAssured.given;

public class ItemsAPITests {

    private static String bearerToken;

    @BeforeClass
    public void setup() {
        // Set base URI for all requests
        RestAssured.baseURI = "http://crater.primetech-apps.com/api/v1";

        // Call login API with hardcoded credentials
        Response loginResponse = ApiUtils.loginAndGetResponse(
                "ajay@primetechschool.com", // <-- replace with your actual email
                "ptschool"            // <-- replace with your actual password
        );

        System.out.println("Login Status: " + loginResponse.statusCode());
        System.out.println("Login Response: " + loginResponse.asPrettyString());

        // Extract token (adjust path if API returns it differently)
        bearerToken = loginResponse.jsonPath().getString("token");
    }


    @Test
    public void createItem() {
        System.out.println("Bearer: " + bearerToken);

        Response response =
                given()
                        .baseUri("http://crater.primetech-apps.com")
                        .header("Authorization", "Bearer " + bearerToken)
                        .accept("application/json")
                        .contentType("application/json")
                        .body("""
              {
                "name": "Palm tree Royal",
                "price": 340,
                "unit_id": 11,
                "description": "Very pretty royal palm created by API"
              }
            """)
                        .log().all()
                        .when()
                        .post("/api/v1/items")
                        .then()
                        .log().all()
                        .extract().response();   // <-- keep the response

        // Debug output
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());

        // Assert status first so failures show body above
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 201");

        // Validate payload
        String createdName = response.jsonPath().getString("data.name");
        Assert.assertEquals(createdName, "Palm tree Royal", "Item name should match request");
    }

}