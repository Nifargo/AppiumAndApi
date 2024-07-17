package org.dkv.app.profileTab.cardScanning;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class AllowScanningPopUp {

    AppiumSelector allowAllTimeButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), xpath("ios"));
    AppiumSelector allowOnlyTimeButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_allow_one_time_button"), xpath("ios"));
    AppiumSelector denyButton = new AppiumSelector(id("com.android.permissioncontroller:id/permission_deny_button"), xpath("ios"));
    AppiumSelector AllowScanningPopUpTitle = new AppiumSelector(id("com.android.permissioncontroller:id/permission_message"), xpath("ios"));

    public String getAllowScanningPopUpTitle() {
        return findByBy(AllowScanningPopUpTitle).getText();
    }

    public CardScanPage clickAllowAllTimeButton() {
        findByBy(allowAllTimeButton).click();
        return new CardScanPage();
    }

    public CardScanPage clickAllowOneTimeButton() {
        findByBy(allowOnlyTimeButton).click();
        return new CardScanPage();
    }

    public CardScanPage clickDenyButton() {
        findByBy(denyButton).click();
        return new CardScanPage();
    }

}
