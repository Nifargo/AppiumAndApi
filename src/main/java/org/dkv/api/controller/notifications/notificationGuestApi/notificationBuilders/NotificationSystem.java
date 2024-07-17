package org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationSystem {
    private String token;
    private OS os;
    private String appVer;

    @Override
    public String toString() {
        return "NotificationSystem{" +
                "token='" + token + '\'' +
                ", os=" + os +
                ", appVer='" + appVer + '\'' +
                '}';
    }
}
