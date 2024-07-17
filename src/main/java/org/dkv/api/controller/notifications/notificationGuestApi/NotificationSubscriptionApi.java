package org.dkv.api.controller.notifications.notificationGuestApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import java.util.List;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appTokenId;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.topicsSubscription;

public class NotificationSubscriptionApi {
    public static Response createNotificationSubscription(String token, List<String> subscriptionTopicsPojo) {
        return RestResource.postWithXApiKey(baseUrl() + baseUrlNotificationFlow() + appTokenId() + "/" + token + topicsSubscription(), subscriptionTopicsPojo, "X_API_KEY_notification_dev_preprod");
    }

    public List<String> sendNotificationTopics(List<String> topic) {
        return topic;
    }
}
