package org.dkv.api.controller.notifications.notificationLoggedInApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.userTokenId;

public class DeleteNotificationUserTokenApi {

    public static Response deleteNotificationUserToken(String token) {
        return RestResource.delete(baseUrl() + baseUrlNotificationFlow() + userTokenId() + "/" + token);
    }
}
