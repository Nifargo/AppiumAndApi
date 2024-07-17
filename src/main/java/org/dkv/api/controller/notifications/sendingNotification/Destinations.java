package org.dkv.api.controller.notifications.sendingNotification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Destinations {

    URGENT_NOTIFICATIONS("urgent_notifications"),
    NETWORK_NEWS("network_news"),
    APP_NEWS("app_news"),
    FUEL_NEWS("fuel_news"),
    EMOBILITY_NEWS("emobility_news");

    private final String destination;
}
