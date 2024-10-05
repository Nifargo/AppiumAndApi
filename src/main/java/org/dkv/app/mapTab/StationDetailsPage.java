package org.dkv.app.mapTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class StationDetailsPage {

    AppiumSelector chargingSessionTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/chargeSessionToolbar"), new AppiumBy.ByAccessibilityId("Search"));

    public boolean visibilityChargingSessionTitle() {
        return findByBy(chargingSessionTitle).isDisplayed();
    }
}
