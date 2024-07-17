package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

public class AndroidNotificationSystem extends NotificationBuilder {
    @Override
    void buildToken() {
        notificationSystem.setToken(NotificationFcmYmlReader.getFcmToken());
    }

    @Override
    void buildOS() {
        notificationSystem.setOs(OS.ANDROID);
    }

    @Override
    void buildAppVersion() {
        notificationSystem.setAppVer("9.2.0");
    }
}
