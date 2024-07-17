package org.dkvProject.api.notificationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.AndroidNotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.IosNotificationSystem;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationDirector;
import org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationSystem;
import org.dkv.api.controller.notifications.notificationLoggedInApi.DeleteNotificationUserTokenApi;
import org.dkv.api.controller.notifications.notificationLoggedInApi.NotificationLoggedInApi;
import org.dkv.api.controller.notifications.notificationLoggedInApi.NotificationUserTokensVerifyApi;
import org.dkv.api.controller.notifications.notificationLoggedInApi.UpdateNotificationUserTokenApi;
import org.dkv.api.model.notificationFlow.notificationToken.NotificationTokenIdPojo;
import org.dkv.api.model.notificationFlow.notificationFlowGuest.UpdateNotificationTokenPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationFcmYmlReader.getFcmTokenNew;
import static org.dkv.api.controller.notifications.notificationLoggedInApi.NotificationLoggedInApi.convertOsToString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class NotificationLoggedInApiTest {
    @Test
    @DisplayName("Get Token Id for Logged In user without Operating System for IOS")
    public void testGetUserTokenIdWithoutOS() {
        String errorMessage = "[ 'operatingSystem' must not be blank ]";

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new IosNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationLoggedInApi().getUserTokenIdPojo(notificationSystem.getToken(), null, notificationSystem.getAppVer());

        Response responseLoggedInUserTokenId = NotificationLoggedInApi.postNotificationUserTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo userTokenPojo = responseLoggedInUserTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseLoggedInUserTokenId).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        assertThat(userTokenPojo.getMessage(), equalTo(errorMessage));
        forResponseStatusMessage(responseLoggedInUserTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);
    }

    @Test
    @DisplayName("Get Token Id for Logged In user without App Version for IOS")
    public void testGetUserTokenIdWithoutAppVersion() {
        String errorMessage = "[ 'appVersion' must not be blank ]";

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new IosNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationLoggedInApi().getUserTokenIdPojo(notificationSystem.getToken(), convertOsToString(notificationSystem.getOs()), null);

        Response responseLoggedInUserTokenId = NotificationLoggedInApi.postNotificationUserTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo userTokenIdPojo = responseLoggedInUserTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseLoggedInUserTokenId).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        assertThat(userTokenIdPojo.getMessage(), equalTo(errorMessage));
        forResponseStatusMessage(responseLoggedInUserTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);
    }

    @Test
    @DisplayName("Get Token Id for Logged In user without App Version for Android")
    public void testGetUserTokenIdWithoutAppVersionAndroid() {
        String errorMessage = "[ 'appVersion' must not be blank ]";

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new AndroidNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationLoggedInApi().getUserTokenIdPojo(notificationSystem.getToken(), convertOsToString(notificationSystem.getOs()), null);

        Response responseLoggedInUserTokenId = NotificationLoggedInApi.postNotificationUserTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo userTokenIdPojo = responseLoggedInUserTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseLoggedInUserTokenId).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        assertThat(userTokenIdPojo.getMessage(), equalTo(errorMessage));
        forResponseStatusMessage(responseLoggedInUserTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);
    }

    @Test
    @DisplayName("Get Token Id for Logged In user for Android")
    public void testGetUserTokenIdForAndroid() {

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new AndroidNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationLoggedInApi().getUserTokenIdPojo
                (notificationSystem.getToken(), convertOsToString(notificationSystem.getOs()), notificationSystem.getAppVer());

        Response responseLoggedInUserTokenId = NotificationLoggedInApi.postNotificationUserTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo userTokenIdPojo = responseLoggedInUserTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseLoggedInUserTokenId).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(responseLoggedInUserTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);
        assertThat(userTokenIdPojo.getTokenId()).isNotNull();
    }

    @Test
    @DisplayName("Get Token Id and verify if FCm token and its user id token are registered and matched, " +
            "check if token is updated and then delete the token.")
    public void testVerifyFcmTokenUserTokenId() {
        String matchMessage = "Token and ID are valid and match.";
        String updateFcmTokenMsg = "Token updated successfully.";
        String VerifyMessageFCMAndTokenIdNotMatch = "Token and ID do not match.";

        NotificationDirector notificationDirector = new NotificationDirector();
        notificationDirector.setNotificationBuilder(new AndroidNotificationSystem());
        NotificationSystem notificationSystem = notificationDirector.createNotificationSystem();

        var notificationTokenIdPojo = new NotificationLoggedInApi().getUserTokenIdPojo(notificationSystem.getToken(), convertOsToString(notificationSystem.getOs()), notificationSystem.getAppVer());

        Response responseLoggedInUserTokenId = NotificationLoggedInApi.postNotificationUserTokenId(notificationTokenIdPojo);
        NotificationTokenIdPojo userTokenIdPojo = responseLoggedInUserTokenId.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseLoggedInUserTokenId).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(responseLoggedInUserTokenId).verifyResponseBodyType(NotificationTokenIdPojo.class);

        String userTokenId = userTokenIdPojo.getTokenId();

        var verifyFcmTokenUserTokenId = new NotificationUserTokensVerifyApi().getUserTokenIdPojo(userTokenId, notificationSystem.getToken());

        Response responseUserTokenIdFcmToken = NotificationUserTokensVerifyApi.getUserTokenIdFcmToken(verifyFcmTokenUserTokenId);
        NotificationTokenIdPojo userTokenIdFcmTokenPojo = responseUserTokenIdFcmToken.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseUserTokenIdFcmToken).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(userTokenIdFcmTokenPojo.getMessage(), equalTo(matchMessage));
        forResponseStatusMessage(responseUserTokenIdFcmToken).verifyResponseBodyType(NotificationTokenIdPojo.class);

        var updatedFcmToken = new UpdateNotificationUserTokenApi().sendNotificationUserToken(getFcmTokenNew());

        Response responseUpdateNotificationToken = UpdateNotificationUserTokenApi.updateNotificationUserToken(userTokenId, updatedFcmToken);
        UpdateNotificationTokenPojo updateNotificationTokenPojo = responseUpdateNotificationToken.as(UpdateNotificationTokenPojo.class);
        forResponseAssertion(responseUpdateNotificationToken).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(responseUpdateNotificationToken).verifyResponseBodyType(UpdateNotificationTokenPojo.class);
        assertThat(updateNotificationTokenPojo.getMessage(), equalTo(updateFcmTokenMsg));

        var fcmTokenUserTokenIdUpdated = new NotificationUserTokensVerifyApi().getUserTokenIdPojo(userTokenId, notificationSystem.getToken());

        Response responseUserTokenIdFcmTokenUpdated = NotificationUserTokensVerifyApi.getUserTokenIdFcmToken(fcmTokenUserTokenIdUpdated);
        NotificationTokenIdPojo userTokenIdFcmTokenUpdatedPojo = responseUserTokenIdFcmTokenUpdated.as(NotificationTokenIdPojo.class);
        forResponseAssertion(responseUserTokenIdFcmTokenUpdated).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
        assertThat(userTokenIdFcmTokenUpdatedPojo.getMessage(), equalTo(VerifyMessageFCMAndTokenIdNotMatch));
        forResponseStatusMessage(responseUserTokenIdFcmTokenUpdated).verifyResponseBodyType(NotificationTokenIdPojo.class);

        Response responseDeleteNotificationTokenId = DeleteNotificationUserTokenApi.deleteNotificationUserToken(userTokenId);
        forResponseAssertion(responseDeleteNotificationTokenId).statusCodeIsEqualTo(StatusCode.NO_CONTENT);
        forResponseAssertion(responseDeleteNotificationTokenId).responseIsEmpty();
        forResponseStatusMessage(responseDeleteNotificationTokenId).verifyResponseBodyType(String.class);
    }
}
