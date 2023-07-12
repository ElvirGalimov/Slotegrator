import java.util.ResourceBundle;

public class TestBase {
    public enum Properties {
        BASE_URL_PATH("baseUrl"),
        LOGIN_PATH("path.ssoAdminLogin"),
        DELETE_ONE_PATH("path.deleteOne"),
        CHECK_EMPTY_PATH("path.checkEmpty"),
        GET_USER_NAME_PATH("path.getUserName"),
        REGISTER_PLAYER_PATH ("path.RegisterPlayer");
        private final String property;
        private String value;

        Properties(String property) {
            this.property = property;
        }

        static {
            ResourceBundle rb = ResourceBundle.getBundle("baseUrl");
            for (Properties prop : values()) {
                prop.value = rb.getString(prop.property);
            }
        }

        public String getValue() {
            return value;
        }
    }
}
