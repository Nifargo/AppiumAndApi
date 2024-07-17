package org.dkv.app.settingsTab;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class NotificationSettings {

    AppiumSelector notificationSettingsTitle = new AppiumSelector(id(PACKAGE_FLAVOR + "id/notificationsSettings"), id("Notification settings"));

    public boolean notificationSettingsTitleIsDisplayed() {
        return findByBy(notificationSettingsTitle).isDisplayed();
    }
}
