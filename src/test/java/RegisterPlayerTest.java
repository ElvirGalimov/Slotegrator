import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class RegisterPlayerTest {
    Properties prop = new Properties();
    String baseUrl = prop.getProperty("baseUrl");
    @Test
    public void registerPlayersTest() {
        RestAssured.baseURI = baseUrl;
        for (int i = 0; i < 12; i++) {
            String playerEmail = "player" + i + "@mail.com";
            String playerName = "player" + i;
            String playerSurname = "surname" + i;
            String playerUsername = "username" + i;
            String playerPassword = "password" + i;

            String requestBody = "{ \"currency_code\": \"USD\", "
                    + "\"email\": \"" + playerEmail + "\", "
                    + "\"name\": \"" + playerName + "\", "
                    + "\"password_change\": \"" + playerPassword + "\", "
                    + "\"password_repeat\": \"" + playerPassword + "\", "
                    + "\"surname\": \"" + playerSurname + "\", "
                    + "\"username\": \"" + playerUsername + "\" }";

            given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post("/api/automationTask/create")
                    .then()
                    .statusCode(201);
        }
    }
}
