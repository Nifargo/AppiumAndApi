package org.dkvProject.api.notificationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.notifications.preferences.UserNotificationsPreferencesApi;
import org.dkv.api.controller.notifications.preferences.UsersNotificationsPreferencesApi;
import org.dkv.api.model.notificationFlow.preferencesFlow.UserPreferencesPojo;
import org.dkv.api.model.notificationFlow.preferencesFlow.UsersPreferencesPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class NotificationsUserPreferencesTests {

    @Test
    @DisplayName("Create or update push notifications preferences for a user")
    public void testPostUserPreferences() {

        String updateMessage = "User preferences updated successfully.";
        List<String> preferences = Arrays.asList("recent_fuel_transactions", "recent_emobility_transactions");

        var notificationPreferencesJson = new UserNotificationsPreferencesApi().buildNotificationPreferencesJson(preferences);

        System.out.println("notificationPreferencesJson: " + notificationPreferencesJson);

        Response notificationsUserPreferences = UserNotificationsPreferencesApi.postUserPreferences("548164", notificationPreferencesJson);
        UserPreferencesPojo userPreferencesPojo = notificationsUserPreferences.as(UserPreferencesPojo.class);
        forResponseAssertion(notificationsUserPreferences).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(userPreferencesPojo.getMessage(), equalTo(updateMessage));
        forResponseStatusMessage(notificationsUserPreferences).verifyResponseBodyType(UserPreferencesPojo.class);
    }

    @Test
    @DisplayName("Try to create or update push notifications preferences for a user with invalid topics")
    public void testPostUserWithoutPreferences() {

        var notificationPreferencesJson = new UserNotificationsPreferencesApi().buildNotificationPreferencesJson(null);

        Response notificationsUserPreferences = UserNotificationsPreferencesApi.updateUserPreferences("548164", notificationPreferencesJson);
        forResponseAssertion(notificationsUserPreferences).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        forResponseStatusMessage(notificationsUserPreferences).verifyResponseBodyType(UserPreferencesPojo.class);
    }

    @Test
    @DisplayName("Get all active notifications preferences for a user that was updated earlier.")
    public void testGetUserPreferencesWithUpdate() {
        List<String> preferences = Arrays.asList("recent_fuel_transactions", "recent_emobility_transactions");

        Response notificationsUserPreferences = UserNotificationsPreferencesApi.getUserPreferences("548164");
        UserPreferencesPojo userPreferencesPojo = notificationsUserPreferences.as(UserPreferencesPojo.class);
        forResponseAssertion(notificationsUserPreferences).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(notificationsUserPreferences).verifyResponseBodyType(UserPreferencesPojo.class);
        assertThat(userPreferencesPojo.getPreferences(), equalTo(preferences));
    }

    @Test
    @DisplayName("Get all active notifications preferences for a user that wasn't updated earlier.")
    public void testGetUserPreferencesWithoutUpdate() {

        Response notificationsUserPreferences = UserNotificationsPreferencesApi.getUserPreferences("547641");
        UserPreferencesPojo userPreferencesPojo = notificationsUserPreferences.as(UserPreferencesPojo.class);
        forResponseAssertion(notificationsUserPreferences).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(notificationsUserPreferences).verifyResponseBodyType(UserPreferencesPojo.class);
        assertThat(userPreferencesPojo.getPreferences()).isEmpty();
    }

    @Test
    @DisplayName("Get all active notifications preferences for multiple users.")
    public void testGetMultipleUsersPreferences() {

        List<Integer> usersIds = Arrays.asList(547641, 548164);

        var listOfUserIds = new UsersNotificationsPreferencesApi().buildNotificationPreferencesJson(usersIds);
        Response notificationsUsersPreferences = UsersNotificationsPreferencesApi.postUsersPreferences(listOfUserIds);
        UsersPreferencesPojo usersPreferencesPojo = notificationsUsersPreferences.as(UsersPreferencesPojo.class);
        forResponseAssertion(notificationsUsersPreferences).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(usersPreferencesPojo.getUserPreferences().get(0).getUserId()).isIn(usersIds);
    }
}
