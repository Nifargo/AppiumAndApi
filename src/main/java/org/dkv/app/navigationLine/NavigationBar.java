package org.dkv.app.navigationLine;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.homeTab.HomePage;
import org.dkv.app.mapTab.MapPage;
import org.dkv.app.profileTab.ProfilePage;
import org.dkv.app.serviceTab.ServicePage;
import org.dkv.app.settingsTab.SettingsPage;

import static common.appiumElementsSettings.AppiumActions.findByBy;

public class NavigationBar {
    AppiumSelector homeButton = new AppiumSelector(new ByAccessibilityId("Home"), new ByAccessibilityId("Home"));
    AppiumSelector mapButton = new AppiumSelector(new ByAccessibilityId("Map"), new ByAccessibilityId("Map"));
    AppiumSelector servicesButton = new AppiumSelector(new ByAccessibilityId("Services"), new ByAccessibilityId("Services"));
    AppiumSelector profileButton = new AppiumSelector(new ByAccessibilityId("Profile"), new ByAccessibilityId("Profile"));
    AppiumSelector settingsButton = new AppiumSelector(new ByAccessibilityId("Settings"), new ByAccessibilityId("Settings"));

    public HomePage clickHomeButton() {
        findByBy(homeButton).click();
        return new HomePage();
    }

    public MapPage clickMapButton() {
        findByBy(mapButton).click();
        return new MapPage();
    }

    public ServicePage clickServiceButton() {
        findByBy(servicesButton).click();
        return new ServicePage();
    }

    public ProfilePage clickProfileButton() {
        findByBy(profileButton).click();
        return new ProfilePage();
    }

    public SettingsPage clickSettingsButton() {
        findByBy(settingsButton).click();
        return new SettingsPage();
    }

    public boolean isProfileButtonIsSelected() {
        return findByBy(profileButton).isNotClickable();
    }
}
