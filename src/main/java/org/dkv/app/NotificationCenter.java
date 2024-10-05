package org.dkv.app;

import common.appiumElementsSettings.AppiumSelector;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.androidJetPackLocator;
import static org.openqa.selenium.By.id;

public class NotificationCenter {

    AppiumSelector notificationBox = new AppiumSelector(androidJetPackLocator("com.android.systemui:id/expandableNotificationRow"), id("ios"));

    public void openNotification() {
        findByBy(notificationBox).click();
    }

    public boolean NotificationMsgNotDisplayed() {
        try {
            return findByBy(notificationBox).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
