import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class DeleteUserTest {
    Properties prop = new Properties();
    String baseUrl = prop.getProperty("baseUrl");
    @Test
    public void deleteUsersTest() {
        RestAssured.baseURI = baseUrl;
        List<String> userIds = Arrays.asList("place", "user", "ID's", "Here");  // Place user ID's here
        for (String userId : userIds) {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .delete("/api/automationTask/deleteOne/" + userId)
                    .then()
                    .statusCode(200);
        }
    }
}
