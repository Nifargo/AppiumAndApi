package org.dkv.app.homeTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.id;

public class PermissionPopUp {

    AppiumSelector permissionAllowButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_allow_button"), new AppiumBy.ByAccessibilityId("Allow"));
    AppiumSelector permissionDenyButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_deny_button"), new AppiumBy.ByAccessibilityId("Deny"));

public boolean permissionAllowButtonIsDisplayed() {
    try {
        return findByBy(permissionAllowButton).isDisplayed();
    } catch (NoSuchElementException | TimeoutException e) {
        return false;
    }
}

    public void clickPermissionAllowButton() {
        findByBy(permissionAllowButton).click();
    }

    public void clickPermissionDenyButton() {
        findByBy(permissionDenyButton).click();
    }
}
