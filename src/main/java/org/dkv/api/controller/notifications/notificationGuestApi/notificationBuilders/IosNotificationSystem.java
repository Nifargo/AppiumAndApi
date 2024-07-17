package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

public class IosNotificationSystem extends NotificationBuilder {
    @Override
    void buildToken() {
        notificationSystem.setToken(NotificationFcmYmlReader.getFcmToken());
    }

    @Override
    void buildOS() {
        notificationSystem.setOs(OS.IOS);
    }

    @Override
    void buildAppVersion() {
        notificationSystem.setAppVer("9.1.5");
    }
}
