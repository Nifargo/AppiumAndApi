package common.locatorsSettings;

public class AppConfiguration {
    public static final String PACKAGE_NAME = "com.dkveuroservice.mobileappkit";

    public static final String FLAVOUR = AppFlavor.STAGING.toString();
    public static final String PACKAGE_FLAVOR = PACKAGE_NAME + "." + FLAVOUR.toLowerCase();

    public static String resourceId(String Id) {
        return ("new UiSelector().resourceId(\"" + Id + "\")");
    }
}
