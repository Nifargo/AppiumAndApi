package org.dkv.app.settingsTab;

import common.appiumElementsSettings.AppiumSelector;
import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import org.dkv.app.homeTab.PermissionPopUp;

import static common.appiumElementsSettings.AppiumActions.find;
import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.appiumElementsSettings.ElementActions.navigateBackMultipleTimes;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByTypeID;
import static common.locatorsSettings.WebTypeElements.DKVBUTTON;
import static common.locatorsSettings.WebTypeElements.DKVCHECKBOX;
import static common.locatorsSettings.WebTypeElements.DKVTOGGLE;
import static common.locatorsSettings.WebTypeElements.INPUT;
import static org.openqa.selenium.By.id;

public class NotificationSettings {

    AppiumSelector notificationSettingsTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/notificationSettingsToolbar"), id("Notification settings"));
    String EnableNotificationToggle = getLocatorByType(DKVTOGGLE, "push-notification-general-toggle");
    String generalToggle = getLocatorByTypeID(INPUT, "dkv-toggle-input");
    String urgentNotificationCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-urgent_notifications-checkbox");
    String networkNewsCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-network_news-checkbox");
    String appNewsCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-app_news-checkbox");
    String fuelNewsCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-fuel_news-checkbox");
    String emobilityNewsCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-emobility_news-checkbox");
    String recentFuelTransactionsCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-recent_fuel_transactions-checkbox");
    String chargingProgressUpdateCheckBox = getLocatorByType(DKVCHECKBOX, "push-notification-recent_emobility_transactions-checkbox");
    String saveButton = getLocatorByType(DKVBUTTON, "push-notification-save-button");

    public boolean notificationSettingsTitleIsDisplayed() {
        return findByBy(notificationSettingsTitle).isDisplayed();
    }

    public void clickEnableNotification() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (isNotificationDisabled()) {
            clickNotificationToggle();
            ContextHandler handler = new ContextHandler();
            handler.changeContext(ContextType.NATIVE);

            if (new PermissionPopUp().permissionAllowButtonIsDisplayed()) {
                new PermissionPopUp().clickPermissionAllowButton();
            } else {
                navigateBackMultipleTimes(1);
            }
        } else {
            navigateBackMultipleTimes(1);
        }
    }

    public void clickNotificationToggle() {
        find(EnableNotificationToggle).click();
    }

    public boolean isNotificationDisabled() {
        return !find(generalToggle).isWebChecked();
    }

    @SuppressWarnings("unused")
    public void clickUrgentNotificationCheckbox() {
        find(urgentNotificationCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickNetworkNewsCheckbox() {
        find(networkNewsCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickAppNewsCheckBox() {
        find(appNewsCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickFuelNewsCheckbox() {
        find(fuelNewsCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickEmobilityNewsCheckbox() {
        find(emobilityNewsCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickRecentFuelTransactionsCheckBox() {
        find(recentFuelTransactionsCheckBox).click();
    }

    @SuppressWarnings("unused")
    public void clickChargingProgressUpdateCheckbox() {
        find(chargingProgressUpdateCheckBox).click();
    }

    public void clickSaveButton() {
        find(saveButton).click();
    }
}
