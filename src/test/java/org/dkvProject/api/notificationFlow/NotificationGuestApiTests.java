package org.dkvProject.api.notificationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.notifications.notificationGuestApi.DeleteNotificationTokenApi;
import org.dkv.api.controller.notifications.notificationGuestApi.NotificationAppTokensVerifyApi;
import org.dkv.api.controller.notifications.notificationGuestApi.NotificationSubscriptionApi;
import org.dkv.api.controller.notifications.notificationGuestApi.NotificationsApi;
import org.dkv.api.controller.notifications.notificationGuestApi.RetrieveSubscriptionsApi;
import org.dkv.api.controller.notifications.notificationGuestApi.UpdateNotificationTokenApi;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.AndroidNotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.IosNotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationDirector;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationSystem;
import org.dkv.api.model.notificationFlow.notificationToken.NotificationTokenIdPojo;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.NotificationAppTokensVerifyPojo;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.RetrieveSubscriptionsListPojo;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.SubscriptionTopicsPojo;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.UpdateNotificationTokenPojo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationFcmYmlReader.getFcmTokenNew;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class NotificationGuestApiTests {

    @ParameterizedTest
    @MethodSource("org.dkv.api.controller.notifications.notificationsData.NotificationsDataGenerator#testData")
    @DisplayName("Try to get tokenId without sending different parameters")
    public void testGetTokenIdWithoutOS(String token, String os, String appVersion) {

        var notificationTokenIdPojo = new NotificationsApi().getTokenIdPojo(token, os, appVersion);

        Response responseNotificationTokenId = NotificationsApi.getNotificationTokenId(notificationTokenIdPojo);
        forResponseAssertion(responseNotificationTokenId).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        forResponseStatusMessage(responseNotificationTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);
    }

//    TODO unskip these tests when we will unlock topics in the notifications settings
    @Disabled
    @Test
    @DisplayName("Get tokenId and update topic subscriptions for a IOS FCM token and retrieve a list of current topics for a specific token")
    public void testUpdateTopicsSubscriptionForIOSUser() {
        List<String> topics = Arrays.asList("fuel_news", "urgent_notifications");

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new IosNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationsApi().getTokenIdPojo(notificationSystem.getToken(), String.valueOf(notificationSystem.getOs()), notificationSystem.getAppVer());
        Response response = NotificationsApi.getNotificationTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo notificationTokenIdResponse = response.as(NotificationTokenIdPojo.class);
        forResponseAssertion(response).statusCodeIsEqualTo(StatusCode.OK);

        String tokenId = notificationTokenIdResponse.getTokenId();

        var subscriptionTopicsPojo = new NotificationSubscriptionApi().sendNotificationTopics(topics);
        Response responseSubscription = NotificationSubscriptionApi.createNotificationSubscription(tokenId, subscriptionTopicsPojo);
        SubscriptionTopicsPojo subscriptionTopicsResponse = responseSubscription.as(SubscriptionTopicsPojo.class);
        forResponseAssertion(responseSubscription).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(subscriptionTopicsResponse.getMessage(), equalTo("Topic subscription update successful."));

        Response responseRetrieveSubscriptionsApi = RetrieveSubscriptionsApi.getNotificationSubscriptionList(tokenId);
        RetrieveSubscriptionsListPojo retrieveSubscriptionsListPojo = responseRetrieveSubscriptionsApi.as(RetrieveSubscriptionsListPojo.class);
        forResponseAssertion(responseRetrieveSubscriptionsApi).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(retrieveSubscriptionsListPojo.getTopics(), equalTo(topics));
        forResponseStatusMessage(responseRetrieveSubscriptionsApi).verifyResponseBodyType(RetrieveSubscriptionsListPojo.class);
    }

    @Disabled
    @Test
    @DisplayName("Get tokenId and update topic subscriptions for a Android FCM token and retrieve a list of current topics for a specific token")
    public void testUpdateTopicsSubscriptionForAndroidUser() {
        List<String> topics = Collections.emptyList();

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new AndroidNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationsApi().getTokenIdPojo(notificationSystem.getToken(), String.valueOf(notificationSystem.getOs()), notificationSystem.getAppVer());
        Response responseNotificationTokenId = NotificationsApi.getNotificationTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo notificationTokenIdResponse = responseNotificationTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseNotificationTokenId).statusCodeIsEqualTo(StatusCode.OK);

        String tokenId = notificationTokenIdResponse.getTokenId();

        var subscriptionTopicsPojo = new NotificationSubscriptionApi().sendNotificationTopics(topics);
        Response responseSubscription = NotificationSubscriptionApi.createNotificationSubscription(tokenId, subscriptionTopicsPojo);
        SubscriptionTopicsPojo subscriptionTopicsResponse = responseSubscription.as(SubscriptionTopicsPojo.class);
        forResponseAssertion(responseSubscription).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(subscriptionTopicsResponse.getMessage(), equalTo("Topic subscription update successful."));

        Response responseRetrieveSubscriptionsApi = RetrieveSubscriptionsApi.getNotificationSubscriptionList(tokenId);
        RetrieveSubscriptionsListPojo retrieveSubscriptionsListPojo = responseRetrieveSubscriptionsApi.as(RetrieveSubscriptionsListPojo.class);
        forResponseAssertion(responseRetrieveSubscriptionsApi).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(retrieveSubscriptionsListPojo.getTopics(), equalTo(topics));
        forResponseStatusMessage(responseRetrieveSubscriptionsApi).verifyResponseBodyType(RetrieveSubscriptionsListPojo.class);
    }

    @Test
    @DisplayName("Verify if an Fcm token and its tokenId are registered and match on the server, then change FCM token and check it again. And delete TokenId after all")
    public void testVerifyTokenIdAndFcmToken() {

        String VerifyMessageFCMAndTokenId = "Token and ID are valid and match.";
        String updateFcmTokenMsg = "Token updated successfully.";
        String VerifyMessageFCMAndTokenIdNotMatch = "Token and ID do not match.";

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new IosNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationsApi().getTokenIdPojo(notificationSystem.getToken(), String.valueOf(notificationSystem.getOs()), notificationSystem.getAppVer());
        Response responseNotificationTokenId = NotificationsApi.getNotificationTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo notificationTokenIdResponse = responseNotificationTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseNotificationTokenId).statusCodeIsEqualTo(StatusCode.OK);

        String tokenId = notificationTokenIdResponse.getTokenId();

        var notificationAppTokensVerifyPojo = new NotificationAppTokensVerifyApi().getTokenIdPojo(tokenId, notificationSystem.getToken());
        Response responseAppTokensVerify = NotificationAppTokensVerifyApi.getTokenIdFcmToken(notificationAppTokensVerifyPojo);
        NotificationAppTokensVerifyPojo notificationAppTokensVerifyResponse = responseAppTokensVerify.as(NotificationAppTokensVerifyPojo.class);
        forResponseAssertion(responseAppTokensVerify).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(notificationAppTokensVerifyResponse.getMessage(), equalTo(VerifyMessageFCMAndTokenId));

        var updateNotificationToken = new UpdateNotificationTokenApi().updateNotificationToken(getFcmTokenNew());
        Response responseUpdateNotificationToken = UpdateNotificationTokenApi.updateNotificationToken(tokenId, updateNotificationToken);
        UpdateNotificationTokenPojo updateNotificationTokenResponse = responseUpdateNotificationToken.as(UpdateNotificationTokenPojo.class);
        forResponseAssertion(responseUpdateNotificationToken).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(updateNotificationTokenResponse.getMessage(), equalTo(updateFcmTokenMsg));

        var notificationNewAppTokensVerifyPojo = new NotificationAppTokensVerifyApi().getTokenIdPojo(tokenId, notificationSystem.getToken());
        Response responseNewAppTokensVerify = NotificationAppTokensVerifyApi.getTokenIdFcmToken(notificationNewAppTokensVerifyPojo);
        NotificationAppTokensVerifyPojo notificationNewAppTokensVerifyResponse = responseNewAppTokensVerify.as(NotificationAppTokensVerifyPojo.class);
        forResponseAssertion(responseNewAppTokensVerify).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        assertThat(notificationNewAppTokensVerifyResponse.getMessage(), equalTo(VerifyMessageFCMAndTokenIdNotMatch));

        Response responseDeleteNotificationToken = DeleteNotificationTokenApi.deleteNotificationToken(tokenId);
        forResponseAssertion(responseDeleteNotificationToken).statusCodeIsEqualTo(StatusCode.NO_CONTENT);
        forResponseAssertion(responseDeleteNotificationToken).responseIsEmpty();
        forResponseStatusMessage(responseDeleteNotificationToken).verifyResponseBodyType(String.class);
    }
}