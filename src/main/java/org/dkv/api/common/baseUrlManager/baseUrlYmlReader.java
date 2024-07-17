package org.dkv.api.common.baseUrlManager;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class baseUrlYmlReader {
    public static String baseUrl() {
        return readYAMLFile("baseUrl", "BASE_URL");
    }

    public static String baseUrlBack() {
        return readYAMLFile("baseUrl", "BASE_URL_back");
    }

    public static String baseUrlFeedBack() {
        return readYAMLFile("baseUrl", "BASE_URL_feedback");
    }

    public static String cardValidate() {
        return readYAMLFile("baseUrl", "Appended_CardValidate");
    }

    public static String baseUrlCardSync() {
        return readYAMLFile("baseUrl", "BASE_URL_cardSync");
    }

    public static String cardSyncOneTime() {
        return readYAMLFile("baseUrl", "Appended_cardSyncOneTime");
    }

    public static String baseUrlIncorrectCardSync() {
        return readYAMLFile("baseUrl", "BASE_URL_incorrectCardSync");
    }
    public static String baseUrlNotificationFlow() {
        return readYAMLFile("baseUrl", "BASE_URL_NotificationFlow");
    }

    public static String appTokenId() {
        return readYAMLFile("baseUrl", "Appended_getTokenId");
    }

    public static String topicsSubscription() {
        return readYAMLFile("baseUrl", "Appended_getSubscription");
    }
    public static String appTokensVerify() {
        return readYAMLFile("baseUrl", "Appended_NotificationAppTokensVerify");
    }

    public static String userTokenId() {
        return readYAMLFile("baseUrl", "Appended_getUserTokenId");
    }

    public static String linkedToUser() {
        return readYAMLFile("baseUrl", "Appended_linkedWithUser");
    }

    public static String notificationUser() {
        return readYAMLFile("baseUrl", "Appended_userCapablePreferences");
    }

    public static String userNotificationCapable() {
        return readYAMLFile("baseUrl", "Appended_notificationCapable");
    }

    public static String baseUrlPreferencesFlow() {
        return readYAMLFile("baseUrl", "BASE_URL_PreferencesFlow");
    }

    public static String appendUsersPreferences() {
        return readYAMLFile("baseUrl", "Appended_usersPreferences");
    }

    public static String baseUrlGetPreferences() {
        return readYAMLFile("baseUrl", "Appended_getPreferences");
    }

    public static String linkV1() {
        return readYAMLFile("baseUrl", "Appended_userV1capable");
    }

    public static String baseUrlSendingNotification(){
        return readYAMLFile("baseUrl", "BASE_URL_SendingNotification");
    }
}
