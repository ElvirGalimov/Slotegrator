import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static io.restassured.RestAssured.given;


public class UserLoginTest extends TestBase {

    @Test
    public void userLoginTest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("currency_code", "string");
        requestBody.put("email", "string");
        requestBody.put("name", "string");
        requestBody.put("password_change", "string");
        requestBody.put("password_repeat", "string");
        requestBody.put("surname", "string");
        requestBody.put("username", "string");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Properties.LOGIN_PATH.getValue())
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
