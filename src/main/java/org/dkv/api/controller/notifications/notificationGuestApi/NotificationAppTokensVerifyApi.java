package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.NotificationAppTokensVerifyPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokensVerify;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;

public class NotificationAppTokensVerifyApi {
    public static Response getTokenIdFcmToken(NotificationAppTokensVerifyPojo notificationAppTokensVerifyPojo) {
        return RestResource.postWithXApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId() + appTokensVerify(), notificationAppTokensVerifyPojo, "X_API_KEY_notification_dev_preprod");
    }

    public NotificationAppTokensVerifyPojo getTokenIdPojo(String tokenId, String fcmToken) {
        return NotificationAppTokensVerifyPojo.builder().
                tokenId(tokenId).
                token(fcmToken).
                build();
    }
}
