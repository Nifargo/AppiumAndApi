package org.dkv.api.controller.feedback.feedbackData;

import java.util.stream.Stream;

import static org.dkv.api.controller.feedback.FeedbackYmlReader.appVersion;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.customerNumber;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.osVersionAndroid;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.osVersionIos;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.reviewTypeDismiss;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.reviewTypeNegative;
import static org.dkv.api.controller.feedback.FeedbackYmlReader.reviewTypePositive;

public class FeedbackDataGenerator {
    static Stream<Object[]> feedbackData() {
        return Stream.of(
                new Object[]{reviewTypePositive(), appVersion(), osVersionAndroid(), customerNumber()},
                new Object[]{reviewTypeNegative(), appVersion(), osVersionIos(), customerNumber()},
                new Object[]{reviewTypeDismiss(), appVersion(), osVersionAndroid(), customerNumber()},
                new Object[]{reviewTypePositive(), appVersion(), osVersionAndroid(), null},
                new Object[]{reviewTypePositive(), appVersion(), null, customerNumber()},
                new Object[]{reviewTypePositive(), null, osVersionAndroid(), customerNumber()}
        );
    }
}
