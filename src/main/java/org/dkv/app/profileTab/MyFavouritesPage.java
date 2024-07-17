package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumActions.findByBy;

public class MyFavouritesPage {
    AppiumSelector emptyFavouritesPage = new AppiumSelector(new ByAccessibilityId("empty list"), By.xpath("//XCUIElementTypeStaticText[@name='You have not yet added any stations to your favourites list.']"));

    public boolean isEmptyFavouritesPage() {
        return findByBy(emptyFavouritesPage).isDisplayed();
    }
}
