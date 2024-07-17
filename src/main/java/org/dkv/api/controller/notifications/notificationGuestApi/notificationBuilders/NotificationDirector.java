package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

import lombok.Setter;

@Setter
public class NotificationDirector {
    NotificationBuilder notificationBuilder;

    public NotificationSystem createNotificationSystem() {
        notificationBuilder.setNotification();
        notificationBuilder.buildToken();
        notificationBuilder.buildOS();
        notificationBuilder.buildAppVersion();

        return notificationBuilder.getNotificationSystem();
    }
}
