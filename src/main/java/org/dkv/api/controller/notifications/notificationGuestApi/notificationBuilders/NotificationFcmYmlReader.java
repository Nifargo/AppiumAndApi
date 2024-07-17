package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class NotificationFcmYmlReader {
    public static String getFcmToken() {
        return readYAMLFile("fcmToken", "token");
    }

    public static String getFcmTokenNew() {
        return readYAMLFile("fcmToken", "token2");
    }
}
