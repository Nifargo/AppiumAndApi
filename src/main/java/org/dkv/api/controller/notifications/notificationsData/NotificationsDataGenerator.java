package org.dkv.api.controller.notifications.notificationsData;

import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.IosNotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationDirector;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.OS;

import java.util.stream.Stream;

public class NotificationsDataGenerator {
    static Stream<Object[]> testData() {
        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new IosNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        return Stream.of(
                new Object[]{notificationSystem.getToken(), null, notificationSystem.getAppVer()},
                new Object[]{null, String.valueOf(OS.ANDROID), notificationSystem.getAppVer()},
                new Object[]{notificationSystem.getToken(), String.valueOf(OS.ANDROID), null},
                new Object[]{notificationSystem.getToken(), String.valueOf(OS.IOS), null}
        );
    }
}
