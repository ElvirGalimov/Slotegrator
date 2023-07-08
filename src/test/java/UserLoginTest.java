import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Properties;
import static io.restassured.RestAssured.given;


public class UserLoginTest {
    Properties prop = new Properties();
    String baseUrl = prop.getProperty("baseUrl");
    @Test
    public void userLoginTest() {
        RestAssured.baseURI = baseUrl;
        String requestBody = "{ \"email\": \"string\", \"password\": \"string\" }";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/tester/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();


        String token = response.jsonPath().getString("token");
        assert(token != null);
    }

    private Matcher<?> notNullValue() {
        return null;
    }

}
