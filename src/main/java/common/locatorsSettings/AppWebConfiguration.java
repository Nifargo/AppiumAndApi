package common.locatorsSettings;

public class AppWebConfiguration {

    public static final String DATA_TEST_ID = "@data-test-id=";

    public static String getLocatorByType(WebTypeElements type, String id) {
        return "//" + type.getType() + "[" + DATA_TEST_ID + "'" + id + "']";
    }
}
