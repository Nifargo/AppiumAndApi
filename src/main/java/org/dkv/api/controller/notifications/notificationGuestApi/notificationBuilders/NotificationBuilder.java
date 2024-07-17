package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

import lombok.Getter;

@Getter
public abstract class NotificationBuilder {
    NotificationSystem notificationSystem;
    public void setNotification(){
        notificationSystem = new NotificationSystem();
    }

    abstract void buildToken();
    abstract void buildOS();
    abstract void buildAppVersion();

}
