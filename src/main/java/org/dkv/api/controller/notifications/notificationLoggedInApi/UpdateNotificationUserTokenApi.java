package org.dkv.api.controller.notifications.notificationLoggedInApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.UpdateNotificationTokenPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.userTokenId;

public class UpdateNotificationUserTokenApi {

    public static Response updateNotificationUserToken(String token, UpdateNotificationTokenPojo updateNotificationToken) {
        return RestResource.update(baseUrl() + baseUrlNotificationFlow() + userTokenId() + "/" + token, updateNotificationToken);
    }

    public UpdateNotificationTokenPojo sendNotificationUserToken(String token) {
        return UpdateNotificationTokenPojo.builder().
                token(token).
                build();
    }


}
