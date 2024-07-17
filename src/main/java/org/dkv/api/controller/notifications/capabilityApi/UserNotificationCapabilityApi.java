package org.dkv.api.controller.notifications.capabilityApi;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.capability.NotificationCapabilityPojo;

import java.util.List;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlNotificationFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.linkV1;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.notificationUser;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.userNotificationCapable;

public class UserNotificationCapabilityApi {
    public static Response getUserNotificationCapable(String userId) {
        return RestResource.getWithNotificationToken(baseUrl() + baseUrlNotificationFlow() + notificationUser() + linkV1() + userId + "/" + userNotificationCapable());
    }

    public static Response postUsersNotificationCapable(NotificationCapabilityPojo usersId) {
        return RestResource.postWithNotificationToken(baseUrl() + baseUrlNotificationFlow() + notificationUser() + linkV1() + userNotificationCapable(), usersId);
    }

    public NotificationCapabilityPojo getUserCapablePojo(List<Integer> userId) {
        return NotificationCapabilityPojo.builder().
                userIds(userId).
                build();
    }
}
