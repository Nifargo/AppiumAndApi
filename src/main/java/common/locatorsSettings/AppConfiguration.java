package common.locatorsSettings;

import io.appium.java_client.AppiumBy;

public class AppConfiguration {

    public static final String PACKAGE_NAME = "com.dkveuroservice.mobileappkit";

    public static final String FLAVOUR = AppFlavor.STAGING.toString();
    public static final String PACKAGE_FLAVOR = PACKAGE_NAME + "." + FLAVOUR.toLowerCase();

    public static AppiumBy.ByAndroidUIAutomator androidJetPackLocator(String resourceId) {
        String uiAutomatorString = "new UiSelector().resourceId(\"" + resourceId + "\")";
        return new AppiumBy.ByAndroidUIAutomator(uiAutomatorString);
    }
}
