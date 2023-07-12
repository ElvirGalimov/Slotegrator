import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CheckEmptyUserList extends TestBase {

    @Test
    public void getUsersAndCheckEmptyTest() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("param1", "value1");
        queryParams.put("param2", "value2");

        Response response = given()
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get(Properties.CHECK_EMPTY_PATH.getValue())
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, ?>> users = response.jsonPath().getList("");
        assert (users.isEmpty());
    }
}
