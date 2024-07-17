package org.dkv.api.controller.feedback;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class FeedbackYmlReader {

    public static String getId() {
        return readYAMLFile("feedbackData", "id");
    }

    public static String reviewTypePositive() {
        return readYAMLFile("feedbackData", "reviewTypePositive");
    }

    public static String reviewTypeNegative() {
        return readYAMLFile("feedbackData", "reviewTypeNegative");
    }

    public static String reviewTypeDismiss() {
        return readYAMLFile("feedbackData", "reviewTypeDismiss");
    }

    public static String appVersion() {
        return readYAMLFile("feedbackData", "appVersion");
    }

    public static String osVersionAndroid() {
        return readYAMLFile("feedbackData", "osVersionAndroid");
    }

    public static String osVersionIos() {
        return readYAMLFile("feedbackData", "osVersionIos");
    }

    public static String customerNumber() {
        return readYAMLFile("feedbackData", "customerNumber");
    }
}
