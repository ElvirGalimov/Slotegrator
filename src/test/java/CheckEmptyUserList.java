import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CheckEmptyUserList {
    Properties prop = new Properties();
    String baseUrl = prop.getProperty("baseUrl");

    @Test
    public void getUsersAndCheckEmptyTest() {
        RestAssured.baseURI = baseUrl;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/automationTask/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, ?>> users = response.jsonPath().getList("");
        assert (users.isEmpty());
    }
}
