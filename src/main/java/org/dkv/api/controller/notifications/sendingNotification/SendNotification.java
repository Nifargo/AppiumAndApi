package org.dkv.api.controller.notifications.sendingNotification;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.notificationFlow.sendingNotification.NotificationBodyPojo;
import org.dkv.api.model.notificationFlow.sendingNotification.RecipientNotificationPojo;
import org.dkv.api.model.notificationFlow.sendingNotification.SendingNotificationDataPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlSendingNotification;

public class SendNotification {

    public static Response postSendUserIdDestination(RecipientNotificationPojo userPreferencesPojo) {
        return RestResource.postWithNotificationToken(baseUrl() + baseUrlSendingNotification(), userPreferencesPojo);
    }

    public static NotificationBodyPojo buildNotificationTitle() {
        return NotificationBodyPojo.builder().
                title("push_notification_ev_stop_charging_title").
                body("push_notification_ev_stop_charging_body").
                build();
    }

    public static SendingNotificationDataPojo dataDestination(String destination) {
        return SendingNotificationDataPojo.builder().
                destination(destination).
                build();
    }

    public static SendingNotificationDataPojo dataDestinationSessionId(String destination, String sessionId) {
        return SendingNotificationDataPojo.builder().
                destination(destination).
                charge_session_id(sessionId).
                build();
    }

    public RecipientNotificationPojo buildSendingNotificationUserId(String usersId, NotificationBodyPojo notification, SendingNotificationDataPojo destination) {
        return RecipientNotificationPojo.builder().
                userId(usersId).
                notification(notification).
                data(destination).
                build();
    }

    public RecipientNotificationPojo buildSendingNotificationToken(String token, NotificationBodyPojo notification , SendingNotificationDataPojo destination) {
        return RecipientNotificationPojo.builder().
                token(token).
                notification(notification).
                data(destination).
                build();
    }

    public RecipientNotificationPojo buildSendingNotificationTopic(Destinations topic, NotificationBodyPojo notification , SendingNotificationDataPojo destination) {
        return RecipientNotificationPojo.builder().
                topic(topic.getDestination()).
                notification(notification).
                data(destination).
                build();
    }
}
