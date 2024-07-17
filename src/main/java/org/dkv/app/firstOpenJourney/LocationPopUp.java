package org.dkv.app.firstOpenJourney;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


public class LocationPopUp {
    AppiumSelector locationMessage = new AppiumSelector(id("com.android.permissioncontroller:id/permission_message"), xpath("/XCUIElementTypeStaticText[@name='Allow “DKV” to use your location?']"));
    AppiumSelector allowAllTimeButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), new ByAccessibilityId("Allow While Using App"));
    AppiumSelector allowOnceButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_allow_one_time_button"), new ByAccessibilityId("Allow Once"));
    AppiumSelector dontAllowButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_deny_button"), new ByAccessibilityId("Don’t Allow"));

    public AnalysisPopUp clickAllowAllTimeButton() {
        findByBy(allowAllTimeButton).click();
        return new AnalysisPopUp();
    }

    public String getLocationMessage() {
        return findByBy(locationMessage).getText();
    }

    public AnalysisPopUp clickAllowOnceButton() {
        findByBy(allowOnceButton).click();
        return new AnalysisPopUp();
    }

    public void clickDontAllowButton() {
        findByBy(dontAllowButton).click();
    }
}
