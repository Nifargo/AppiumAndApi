package org.dkv.api.controller.notifications.preferences;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.preferencesFlow.UsersPreferencesPojo;

import java.util.List;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.appendUsersPreferences;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlGetPreferences;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlPreferencesFlow;

public class UsersNotificationsPreferencesApi {
    public static Response postUsersPreferences(UsersPreferencesPojo userPreferencesPojo) {
        return RestResource.postWithNotificationToken(baseUrl() + baseUrlPreferencesFlow() + appendUsersPreferences() + baseUrlGetPreferences(), userPreferencesPojo);
    }

    public UsersPreferencesPojo buildNotificationPreferencesJson(List<Integer> usersIds) {
        return UsersPreferencesPojo.builder().
                userIds(usersIds).
                build();
    }
}
