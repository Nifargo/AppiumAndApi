package common.appiumElementsSettings;

import io.appium.java_client.AppiumBy;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;
import static common.appiumElementsSettings.AppiumInit.isIos;
import static common.waitUtils.WaitUtils.waitFor;

@UtilityClass

public class AppiumActions {
    public static ElementActions findByBy(AppiumSelector selector) {
        By locator = isIos() ? selector.getByIOS() : selector.getByAndroid();
        return new ElementActions(getAppiumDriver().findElement(locator));
    }

    public static ElementActions find(By locator) {
        return new ElementActions(getAppiumDriver().findElement(locator));
    }

    public static ElementActions find(String xpath) {
        waitFor(By.xpath(xpath));
        return new ElementActions(getAppiumDriver().findElement(By.xpath(xpath)));
    }

    public static ElementActions findByUiAutomator(String uiAutomatorExpression) {
        waitFor(AppiumBy.androidUIAutomator(uiAutomatorExpression));
        return new ElementActions(getAppiumDriver().findElement(AppiumBy.androidUIAutomator(uiAutomatorExpression)));
    }

    public static ElementActions findId(String id) {
        waitFor(By.id(id));
        return new ElementActions(getAppiumDriver().findElement(By.id(id)));
    }

    public static ElementActions findByDataId(String dataTestId) {
        waitFor(By.xpath(dataTestId));
        return new ElementActions(getAppiumDriver().findElement(By.xpath(dataTestId)));
    }

    public static ElementActions findByAccess(String accessibilityId) {
        By accessibilityIdSelector = AppiumBy.accessibilityId(accessibilityId);
        return new ElementActions(getAppiumDriver().findElement(accessibilityIdSelector));
    }

    public static ElementActions findByResId(String resourceId) {
        By resourceIdSelector = AppiumBy.id(resourceId);
        waitFor(resourceIdSelector);
        return new ElementActions(getAppiumDriver().findElement(resourceIdSelector));
    }

    public static ElementActions findByClass(String className) {
        waitFor(By.className(className));
        return new ElementActions(getAppiumDriver().findElement(By.className(className)));
    }
}

