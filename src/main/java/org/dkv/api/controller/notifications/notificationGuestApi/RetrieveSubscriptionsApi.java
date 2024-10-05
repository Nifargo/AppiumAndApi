package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.topicsSubscription;

public class RetrieveSubscriptionsApi {
    public static Response getNotificationSubscriptionList(String token) {
        return RestResource.getWithApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId() + "/" + token + topicsSubscription(), "X_API_KEY_notification_dev_preprod");
    }
}
