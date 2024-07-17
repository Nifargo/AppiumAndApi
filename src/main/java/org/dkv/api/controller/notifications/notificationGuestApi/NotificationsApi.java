package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.notificationToken.NotificationTokenIdPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;

public class NotificationsApi {
    public static Response getNotificationTokenId(NotificationTokenIdPojo notificationTokenIdPojo) {
        return RestResource.postWithXApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId(), notificationTokenIdPojo, "X_API_KEY_notification_dev_preprod");
    }

    public NotificationTokenIdPojo getTokenIdPojo(String fcmToken, String os, String appVersion) {
        return NotificationTokenIdPojo.builder().
                token(fcmToken).
                operatingSystem(os).
                appVersion(appVersion).
                build();
    }
}
