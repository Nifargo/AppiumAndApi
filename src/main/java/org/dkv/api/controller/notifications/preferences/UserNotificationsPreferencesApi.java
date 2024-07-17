package org.dkv.api.controller.notifications.preferences;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.preferencesFlow.UserPreferencesPojo;

import java.util.List;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlGetPreferences;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlPreferencesFlow;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.notificationUser;

public class UserNotificationsPreferencesApi {
    public static Response postUserPreferences(String userId, UserPreferencesPojo userPreferencesPojo) {
        return RestResource.post(baseUrl() + baseUrlPreferencesFlow() + notificationUser() + "/" + userId + "/" + baseUrlGetPreferences(), userPreferencesPojo);
    }

    public static Response updateUserPreferences(String userId, UserPreferencesPojo userPreferencesPojo) {
        return RestResource.postWithNotificationToken(baseUrl() + baseUrlPreferencesFlow() + notificationUser() + "/" + userId + "/" + baseUrlGetPreferences(), userPreferencesPojo);
    }

    public static Response getUserPreferences(String userId) {
        return RestResource.getWithNotificationToken(baseUrl() + baseUrlPreferencesFlow() + notificationUser() + "/" + userId + "/" + baseUrlGetPreferences());
    }

    public UserPreferencesPojo buildNotificationPreferencesJson(List<String> preferences) {
        return UserPreferencesPojo.builder().
                preferences(preferences).
                build();
    }
}
