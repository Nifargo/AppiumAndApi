package org.dkv.api.controller.notifications.notificationLoggedInApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.OS;
import org.dkv.api.model.notificationFlow.notificationToken.NotificationTokenIdPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.userTokenId;

public class NotificationLoggedInApi {

    public static Response postNotificationUserTokenId(NotificationTokenIdPojo notificationTokenIdPojo) {
        return RestResource.post(baseUrl() + baseUrlNotificationFlow() + userTokenId(), notificationTokenIdPojo);
    }

    public static String convertOsToString(OS osType) {
        return String.valueOf(osType);
    }

    public NotificationTokenIdPojo getUserTokenIdPojo(String fcmToken, String os, String appVersion) {
        return NotificationTokenIdPojo.builder().
                token(fcmToken).
                operatingSystem(os).
                appVersion(appVersion).
                build();
    }
}
