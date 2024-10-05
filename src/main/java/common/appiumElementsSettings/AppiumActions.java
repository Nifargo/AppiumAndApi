package common.appiumElementsSettings;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;
import static common.appiumElementsSettings.AppiumInit.isIos;
import static common.waitUtils.WaitUtils.waitFor;
import static common.waitUtils.WaitUtils.waitForBy;

@UtilityClass

public class AppiumActions {

    public static ElementActions findByBy(AppiumSelector selector) {
        By locator = waitForBy(isIos() ? selector.getByIOS() : selector.getByAndroid());
        return new ElementActions(getAppiumDriver().findElement(locator));
    }

    public static ElementActions find(By locator) {
        waitFor(locator);
        return new ElementActions(getAppiumDriver().findElement(locator));
    }

    public static ElementActions find(String xpath) {
        waitFor(By.xpath(xpath));
        return new ElementActions(getAppiumDriver().findElement(By.xpath(xpath)));
    }

    @SuppressWarnings("unused")
    public static ElementActions findByUiAutomator(String uiAutomatorExpression) {
        waitFor(AppiumBy.androidUIAutomator(uiAutomatorExpression));
        return new ElementActions(getAppiumDriver().findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression)));
    }

    @SuppressWarnings("unused")
    public static ElementActions findId(String id) {
        waitFor(By.id(id));
        return new ElementActions(getAppiumDriver().findElement(By.id(id)));
    }

    @SuppressWarnings("unused")
    public static ElementActions findByDataId(String dataTestId) {
        waitFor(By.xpath(dataTestId));
        return new ElementActions(getAppiumDriver().findElement(By.xpath(dataTestId)));
    }

    @SuppressWarnings("unused")
    public static ElementActions findByAccess(String accessibilityId) {
        By accessibilityIdSelector = AppiumBy.accessibilityId(accessibilityId);
        return new ElementActions(getAppiumDriver().findElement(accessibilityIdSelector));
    }

    @SuppressWarnings("unused")
    public static ElementActions findByResId(String resourceId) {
        By resourceIdSelector = AppiumBy.id(resourceId);
        waitFor(resourceIdSelector);
        return new ElementActions(getAppiumDriver().findElement(resourceIdSelector));
    }

    @SuppressWarnings("unused")
    public static ElementActions findByClass(String className) {
        waitFor(By.className(className));
        return new ElementActions(getAppiumDriver().findElement(By.className(className)));
    }

    public static By getByLocatorForCurrentPlatform(AppiumSelector locator) {
        if (getAppiumDriver() instanceof AndroidDriver) {
            return locator.getByAndroid();
        } else if (getAppiumDriver() instanceof IOSDriver) {
            return locator.getByIOS();
        } else {
            return null;
        }
    }
}

