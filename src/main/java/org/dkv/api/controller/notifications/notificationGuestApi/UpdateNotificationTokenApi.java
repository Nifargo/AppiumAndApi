package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.UpdateNotificationTokenPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;

public class UpdateNotificationTokenApi {
    public static Response updateNotificationToken(String token, UpdateNotificationTokenPojo updateNotificationToken) {
        return RestResource.updateWithApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId() + "/" + token, updateNotificationToken, "X_API_KEY_notification_dev_preprod");
    }

    public UpdateNotificationTokenPojo updateNotificationToken(String token) {
        return UpdateNotificationTokenPojo.builder().
                token(token).
                build();
    }
}
