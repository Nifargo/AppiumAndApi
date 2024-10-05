package common.appiumElementsSettings;

import common.systemLogger.AppLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class AppiumInit {
    private static final Logger logger = AppLogger.getLogger(AppiumInit.class);

    private final ConcurrentHashMap<Long, AppiumDriver> appiumDriverMap = new ConcurrentHashMap<>();
    protected Properties props;

    static {
        String isSauceLab = System.getProperty("isSauceLab");
        String isIOS = System.getProperty("isIOS");

        if ("true".equals(isIOS)) {
            logger.info("Using iOS configuration...");
            configureIOSDriver();
        } else if ("true".equals(isSauceLab)) {
            logger.info("Using Sauce Labs configuration...");
            configureAndroidSauceLabDriver();
        } else {
            logger.info("Using local Android configuration...");
            configureAndroidDriver();
        }
    }

    public static boolean isIos() {
        return Objects.equals(System.getProperty("isIOS"), "true");
    }

    @SneakyThrows
    public void configureAndroidDriver() {
        props = new Properties();
        props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/data/properties/DataProperties"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("platformNameAndroid"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("AndroidDeviceName"));
        capabilities.setCapability("avd", "autoTests");
        capabilities.setCapability("avdLaunchTimeout", 180000);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "android" + File.separator + "androidReleaseBuild.apk";
        capabilities.setCapability(MobileCapabilityType.APP, appUrl);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);
        String ipAddress = new Properties().getProperty("ipAddress");
        AndroidDriver androidDriver = new AndroidDriver(new AppiumServiceBuilder().withIPAddress(ipAddress), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appiumDriverMap.put(Thread.currentThread().getId(), androidDriver);
    }

    @SneakyThrows
    private void configureAndroidSauceLabDriver(){
        props = new Properties();
        props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/data/properties/DataProperties"));

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, props.getProperty("platformNameAndroid"));
        capabilities.setCapability("appium:app", "storage:filename=androidReleaseBuild.apk");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("AndroidDeviceNameSauce"));
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.11.0");
        sauceOptions.setCapability("username", props.getProperty("sauceUsername"));
        sauceOptions.setCapability("accessKey", props.getProperty("sauceAccessKey"));
        sauceOptions.setCapability("build", props.getProperty("sauceBuildAndroid"));
        sauceOptions.setCapability("name", props.getProperty("sauceTestNameAndroid"));
        sauceOptions.setCapability("deviceOrientation", props.getProperty("deviceOrientation"));
        capabilities.setCapability("sauce:options", sauceOptions);

        URL url = new URL(props.getProperty("sauceUrl"));
        AndroidDriver androidDriver = new AndroidDriver(url, capabilities);

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appiumDriverMap.put(Thread.currentThread().getId(), androidDriver);
    }

    @SneakyThrows
    private void configureIOSDriver() {
        props = new Properties();
        props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/data/properties/DataProperties"));

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:filename=DKV 1.ipa");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "iPhone.*");
        caps.setCapability("appium:automationName", "XCUITest");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "Nifargo");
        sauceOptions.setCapability("accessKey", "695aec88-a6cf-4f42-a1b6-6de39e1e0279");
        sauceOptions.setCapability("build", "appium-build-GQYPW");
        sauceOptions.setCapability("name", "<IOS regression tests>");
        caps.setCapability("sauce:options", sauceOptions);

        String sauceUrl = "https://Nifargo:695aec88-a6cf-4f42-a1b6-6de39e1e0279@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

        IOSDriver iosDriver;
        try {
            iosDriver = new IOSDriver(new URL(sauceUrl), caps);
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            appiumDriverMap.put(Thread.currentThread().getId(), iosDriver);
        } catch (MalformedURLException e) {
            logger.error("Malformed URL Exception{}", e.getMessage());
        }
    }

    private static AppiumDriver getDriverFromMap() {
        AppiumDriver driver = appiumDriverMap.get(Thread.currentThread().getId());
        if (driver == null) {
            throw new IllegalStateException("No driver found for the current thread");
        }
        return driver;
    }

    private static AppiumDriver checkDriverType(AppiumDriver driver) {
        if (Objects.equals(System.getProperty("isIOS"), "true")) {
            if (driver instanceof IOSDriver) {
                return (IOSDriver) driver;
            } else {
                throw new IllegalStateException("Driver is not an instance of IOSDriver");
            }
        } else {
            if (driver instanceof AndroidDriver) {
                return (AndroidDriver) driver;
            } else {
                throw new IllegalStateException("Driver is not an instance of AndroidDriver");
            }
        }
    }

    public static AppiumDriver getAppiumDriver() {
        AppiumDriver driver = getDriverFromMap();
        return checkDriverType(driver);
    }

    @SuppressWarnings("unused")
    public void stopAppiumDriver() {
        List<Long> driversToClose = new ArrayList<>();
        for (Map.Entry<Long, AppiumDriver> entry : appiumDriverMap.entrySet()) {
            AppiumDriver appiumDriver = entry.getValue();
            if (appiumDriver != null) {
                try {
                    appiumDriver.quit();
                    driversToClose.add(entry.getKey());
                } catch (Throwable e) {
                    System.err.println("Appium driver Error: " + e.getMessage());
                }
            }
        }
        for (Long driverId : driversToClose) {
            appiumDriverMap.remove(driverId);
        }
    }

    @SuppressWarnings("unused")
    private static void setPropertiesForOldRealDevice(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("1af75d19"));
    }

    @SuppressWarnings("unused")
    private static void setPropertiesForNewRealDevice(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("43191JEKB10367"));
    }

    @SuppressWarnings("unused")
    private static void addChromeDriverAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("chromedriverExecutable", "/Users/nifargo/Downloads/chromedriver-mac-arm64/chromedriver");
    }

    @SuppressWarnings("unused")
    private static void includeSafariInWeviewsIosCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("includeSafariInWeviews", true);
    }

    @SuppressWarnings("unused")
    private static void setWebviewConnectTimeoutIosCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("webviewConnectTimeout", "90000");
    }

    @SuppressWarnings("unused")
    private static void setChromeDriverExecutableAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("chromedriverExecutable", "/Users/nifargo/Downloads/chromedriver-mac-arm64/chromedriver");
    }

    @SuppressWarnings("unused")
    private static void setAppPackageAndActivityAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("appPackage", "com.dkveuroservice.mobileappkit");
        capabilities.setCapability("appActivity", "com.dkveuroservice.mobileappkit.MainActivity");
    }
}