package org.dkvProject.api.notificationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.notifications.capabilityApi.UserNotificationCapabilityApi;
import org.dkv.api.model.notificationFlow.notificationToken.NotificationTokenIdPojo;
import org.dkv.api.model.notificationFlow.capability.NotificationCapabilityPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class NotificationCapabilityApiTests {
    @Test
    @DisplayName("Check single user notification capability.")
    public void testForCapability() {
        String userId = "548164";

        Response userNotificationCapableResponse = UserNotificationCapabilityApi.getUserNotificationCapable(userId);

        forResponseAssertion(userNotificationCapableResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(userNotificationCapableResponse).verifyResponseBodyType(NotificationTokenIdPojo.class);
        NotificationCapabilityPojo userNotificationCapablePojo = userNotificationCapableResponse.as(NotificationCapabilityPojo.class);
        assertThat(userNotificationCapablePojo.getUserId(), equalTo(Integer.parseInt(userId)));
        assertThat(userNotificationCapablePojo.getIsNotificationCapable(), equalTo(true));
    }

    @Test
    @DisplayName("Check multiple user notification capability.")
    public void testForMultipleCapability() {
        List<Integer> userId = Arrays.asList(548164, 548165);

        var usersNotificationCapable = new UserNotificationCapabilityApi().getUserCapablePojo(userId);

        Response usersNotificationCapableResponse = UserNotificationCapabilityApi.postUsersNotificationCapable(usersNotificationCapable);

        forResponseAssertion(usersNotificationCapableResponse).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(usersNotificationCapableResponse).verifyResponseBodyType(NotificationTokenIdPojo.class);
    }
}
