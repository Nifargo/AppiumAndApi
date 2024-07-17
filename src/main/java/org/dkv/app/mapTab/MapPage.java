package org.dkv.app.mapTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class MapPage {

    AppiumSelector searchField = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/searchEt"), new AppiumBy.ByAccessibilityId("Search"));
    AppiumSelector listButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/list"), new AppiumBy.ByAccessibilityId("List"));
    AppiumSelector noStationDisplayMsg = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/error_text"), new AppiumBy.ByAccessibilityId("No station display message"));

    public void clickListButton() {
        findByBy(listButton).click();
    }

}
