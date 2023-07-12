import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Properties;

public class GetUserAndSortByNameTest extends TestBase {

    @Test
    public void getUserAndSortByName() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(Properties.GET_USER_NAME_PATH.getValue())
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, ?>> users = response.jsonPath().getList("");
        users.sort(Comparator.comparing(user -> (String) user.get("name")));

        String lastName = "";
        for (Map<String, ?> user : users) {
            String name = (String) user.get("name");
            System.out.println(name);

            Assert.assertTrue(name.compareTo(lastName) >= 0);
            lastName = name;
        }
    }
}
