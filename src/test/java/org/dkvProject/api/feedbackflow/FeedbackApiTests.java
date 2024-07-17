package org.dkvProject.api.feedbackflow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.feedback.FeedbackApi;
import org.dkv.api.model.feedbackFlow.FeedbackPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

@Tag("api")
public class FeedbackApiTests {
    @ParameterizedTest
    @MethodSource("org.dkv.api.controller.feedback.feedbackData.FeedbackDataGenerator#feedbackData")
    @DisplayName("Check if logged in user can send feedback with different parameters")
    public void testLoggedInPositiveAndroidFeedback(String reviewType, String appVersion, String osVersion, String customerNumber) {

        var feedbackPojo = new FeedbackApi().FeedbackPojoBuilder(reviewType, appVersion, osVersion, customerNumber);

        Response response = FeedbackApi.sendFeedback(feedbackPojo);
        FeedbackPojo feedbackResponse = response.as(FeedbackPojo.class);

        forResponseAssertion(response).statusCodeIsEqualTo(StatusCode.OK);
        new FeedbackApi().assertFeedbackFlowEqual(feedbackResponse, feedbackPojo);
        assertThat(feedbackResponse.getCreatedAt(), matchesPattern("^.*T.*$"));
        assertThat(feedbackResponse.getId(), matchesPattern("^[a-z0-9-]*$"));
    }
}
