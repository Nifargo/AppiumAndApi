package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;

public class DeleteNotificationTokenApi {

    public static Response deleteNotificationToken(String token) {
        return RestResource.deleteWithApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId() + "/" + token, "X_API_KEY_notification_dev_preprod");
    }
}
