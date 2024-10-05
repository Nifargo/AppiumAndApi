package helpers.baseHelpers;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;

public class HelpersMethod {

    public static TouchAction getTouchAction() {
        return new TouchAction((PerformsTouchActions) getAppiumDriver());
    }

    public static void scrollDown(
            double startPercentage, double finalPercentage, double anchorPercentage, int duration) {
        org.openqa.selenium.Dimension size = getAppiumDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);
        getTouchAction().press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(anchor, endPoint)).release().perform();
    }

    public static void scrollUsingJS(DirectionForWebScrolling direction) {
        WebDriver driver = getAppiumDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (DirectionForWebScrolling.UP.equals(direction)) {
            js.executeScript("window.scrollTo(0, 0)");
        } else if (DirectionForWebScrolling.DOWN.equals(direction)) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

    public static void navigateBackMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            getAppiumDriver().navigate().back();
        }
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception caught during sleep: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void resetApp() {
        if (getAppiumDriver() instanceof AndroidDriver) {
            ((AndroidDriver) getAppiumDriver()).resetApp();
        } else if (getAppiumDriver() instanceof IOSDriver) {
            ((IOSDriver) getAppiumDriver()).resetApp();
        } else {
            throw new IllegalStateException("Driver type is not supported for this method");
        }
    }

    @SuppressWarnings("unused")
    public static void closeApp() {
        if (getAppiumDriver() instanceof AndroidDriver) {
            ((AndroidDriver) getAppiumDriver()).terminateApp(getAppiumDriver().getCapabilities().getCapability("appPackage").toString());
        } else if (getAppiumDriver() instanceof IOSDriver) {
            ((IOSDriver) getAppiumDriver()).terminateApp(getAppiumDriver().getCapabilities().getCapability("appPackage").toString());
        } else {
            throw new IllegalStateException("Driver type is not supported for this method");
        }
    }

    public void openNotificationsCenter() {
        if (getAppiumDriver() instanceof AndroidDriver) {
            ((AndroidDriver) getAppiumDriver()).openNotifications();
        } else if (getAppiumDriver() instanceof IOSDriver) {
            throw new IllegalStateException("Driver type is not supported for this method");
        } else {
            throw new IllegalStateException("Driver type is not supported for this method");
        }
    }
}
