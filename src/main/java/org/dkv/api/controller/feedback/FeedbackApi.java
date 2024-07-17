package org.dkv.api.controller.feedback;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.feedbackFlow.FeedbackPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlFeedBack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FeedbackApi {

    public static Response sendFeedback(FeedbackPojo feedbackPojo) {
        return RestResource.post(baseUrl() + baseUrlFeedBack(), feedbackPojo);
    }

    public FeedbackPojo FeedbackPojoBuilder(String reviewType, String appVersion, String osVersion, String customerNumber) {
        return FeedbackPojo.builder().
                reviewType(reviewType).
                appVersion(appVersion).
                osVersion(osVersion).
                customerNumber(customerNumber).
                build();
    }

    public void assertFeedbackFlowEqual(FeedbackPojo feedbackResponse, FeedbackPojo feedbackPojo) {
        assertThat(feedbackResponse.getReviewType(), equalTo(feedbackPojo.getReviewType()));
        assertThat(feedbackResponse.getAppVersion(), equalTo(feedbackPojo.getAppVersion()));
        assertThat(feedbackResponse.getOsVersion(), equalTo(feedbackPojo.getOsVersion()));
        assertThat(feedbackResponse.getCustomerNumber(), equalTo(feedbackPojo.getCustomerNumber()));
    }
}
