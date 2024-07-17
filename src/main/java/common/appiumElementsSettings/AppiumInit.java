package common.appiumElementsSettings;

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

    private final ConcurrentHashMap<Long, AppiumDriver> appiumDriverMap = new ConcurrentHashMap<>();
    protected Properties props;

    static {
        if (Objects.equals(System.getProperty("isIOS"), "true")) {
            configureIOSDriver();
        } else {
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
        capabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 800);
        String ipAddress = new Properties().getProperty("ipAddress");
        AndroidDriver androidDriver = new AndroidDriver(new AppiumServiceBuilder().withIPAddress(ipAddress), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        appiumDriverMap.put(Thread.currentThread().getId(), androidDriver);

//        Android SouceLabs configuration
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:app", "storage:filename=androidReleaseBuild.apk");
//        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
//        caps.setCapability("appium:deviceOrientation", "portrait");
//        caps.setCapability("appium:platformVersion", "12.0");
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "Nifargo");
//        sauceOptions.setCapability("accessKey", "712257a1-3a40-4834-bfb6-b16dc5952419");
//        sauceOptions.setCapability("build", "appium-build-UNVTK");
//        sauceOptions.setCapability("name", "<AndroidTestsOnSourceLab>");
//        caps.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        AndroidDriver androidDriverSauce = new AndroidDriver(url, caps);
//
//        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @SneakyThrows
    private void configureIOSDriver() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("app", "storage:filename=<DKVRelease.ipa>");
        caps.setCapability("deviceName", "iPhone XS Simulator");
        caps.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("platformVersion", "16.2");
        caps.setCapability("automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "Nifargo");
        sauceOptions.setCapability("accessKey", "695aec88-a6cf-4f42-a1b6-6de39e1e0279");
        sauceOptions.setCapability("build", "appium-build-WYA96");
        sauceOptions.setCapability("name", "<IOS regression tests>");
        sauceOptions.setCapability("language", "en");
        caps.setCapability("sauce:options", sauceOptions);

        String sauceUrl = "https://Nifargo:695aec88-a6cf-4f42-a1b6-6de39e1e0279@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

        IOSDriver iosDriver;
        try {
            iosDriver = new IOSDriver(new URL(sauceUrl), caps);
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            appiumDriverMap.put(Thread.currentThread().getId(), iosDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriverMap.get(Thread.currentThread().getId());
    }

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

    private static void addChromeDriverAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("chromedriverExecutable", "/Users/nifargo/Downloads/chromedriver-mac-arm64/chromedriver");
    }

    private static void includeSafariInWeviewsIosCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("includeSafariInWeviews", true);
    }

    private static void setWebviewConnectTimeoutIosCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("webviewConnectTimeout", "90000");
    }

    private static void setChromeDriverExecutableAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("chromedriverExecutable", "/Users/nifargo/Downloads/chromedriver-mac-arm64/chromedriver");
    }

    private static void setAppPackageAndActivityAndroidCapability(DesiredCapabilities capabilities) {
        capabilities.setCapability("appPackage", "com.dkveuroservice.mobileappkit");
        capabilities.setCapability("appActivity", "com.dkveuroservice.mobileappkit.MainActivity");
    }
}