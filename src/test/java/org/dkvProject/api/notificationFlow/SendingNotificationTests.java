package org.dkvProject.api.notificationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.notifications.sendingNotification.SendNotification;
import org.dkv.api.model.notificationFlow.sendingNotification.RecipientNotificationPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.dkv.api.controller.notifications.notificationGuestApi.notificationBuilders.NotificationFcmYmlReader.getFcmToken;
import static org.dkv.api.controller.notifications.sendingNotification.Destinations.APP_NEWS;
import static org.dkv.api.controller.notifications.sendingNotification.SendNotification.buildNotificationTitle;
import static org.dkv.api.controller.notifications.sendingNotification.SendNotification.dataDestination;
import static org.dkv.api.controller.notifications.sendingNotification.SendNotification.dataDestinationSessionId;

@Tag("api")
public class SendingNotificationTests {

    @Test
    @DisplayName("Sending notification with user id and destination Home page")
    public void testSendingUserIdHomePage() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationUserId("548164", buildNotificationTitle(), dataDestination("open_home_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with user id and destination Map page")
    public void testSendingUserIdMapPage() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationUserId("548164", buildNotificationTitle(), dataDestination("open_map_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with user id and destination Transactions page")
    public void testSendingUserIdTransactionsPage() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationUserId("548164", buildNotificationTitle(), dataDestination("open_transaction_history_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with user id and destination My DKV cards page")
    public void testSendingUserIdMyCardsPage() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationUserId("548164", buildNotificationTitle(), dataDestination("open_my_cards_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with user id and destination active charging session Id")
    public void testSendingUserIdChargingSession() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationUserId("548164", buildNotificationTitle(), dataDestinationSessionId("open_ev_active_charging_screen", "23cb3aac-c524-43fd-a52a-0f3c8d7a8a4d"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with topic network_news and destination My DKV cards page")
    public void testSendingTopics() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationTopic(APP_NEWS, buildNotificationTitle(), dataDestination("open_my_cards_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }

    @Test
    @DisplayName("Sending notification with FCm token and destination My DKV cards page")
    public void testSendingFcmToken() {

        var sendingNotificationRequest = new SendNotification().buildSendingNotificationToken(getFcmToken(), buildNotificationTitle(), dataDestination("open_my_cards_screen"));

        Response SendingResponse = SendNotification.postSendUserIdDestination(sendingNotificationRequest);
        forResponseAssertion(SendingResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(SendingResponse).verifyResponseBodyType(RecipientNotificationPojo.class);
    }
}
