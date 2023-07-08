import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.Properties;

public class GetUserAndSortByNameTest {
    Properties prop = new Properties();
    String baseUrl = prop.getProperty("baseUrl");

   @Test
   public void getUserAndSortByName(){
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
       users.sort(Comparator.comparing(user -> (String) user.get("name")));
       for (Map<String, ?> user : users) {
           System.out.println(user.get("name"));
       }


   }
}
