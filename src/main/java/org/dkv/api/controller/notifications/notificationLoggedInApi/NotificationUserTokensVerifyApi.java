package org.dkv.api.controller.notifications.notificationLoggedInApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.NotificationAppTokensVerifyPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokensVerify;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.userTokenId;

public class NotificationUserTokensVerifyApi {

    public static Response getUserTokenIdFcmToken(NotificationAppTokensVerifyPojo notificationAppTokensVerifyPojo) {
        return RestResource.post(baseUrl() + baseUrlNotificationFlow() + userTokenId() + appTokensVerify(), notificationAppTokensVerifyPojo);
    }

    public NotificationAppTokensVerifyPojo getUserTokenIdPojo(String tokenId, String fcmToken) {
        return NotificationAppTokensVerifyPojo.builder().
                tokenId(tokenId).
                token(fcmToken).
                build();
    }

}
