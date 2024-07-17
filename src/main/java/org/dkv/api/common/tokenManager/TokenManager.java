package org.dkv.api.common.tokenManager;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import java.time.Instant;
import java.util.HashMap;

import static common.systemLogger.AppLogger.logger;
import static org.dkv.api.common.tokenManager.TokenYmlReader.secret;
import static org.dkv.api.common.tokenManager.TokenYmlReader.token;

public class TokenManager {

    private static Instant expiry_time;

    public static String getToken() {
        String accessToken = null;
        try {
            if (accessToken == null || Instant.now().isAfter(expiry_time)) {
                Response response = renewToken();
                accessToken = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 30);
            } else {
                throw new RuntimeException("Token is good to use");
            }
        } catch (Exception e) {
            logger.error("Error is here" + e);
            throw new RuntimeException("ABORT! Failed to get a token");
        }
        return accessToken;
    }

    private static Response renewToken() {

        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "refresh_token");
        formParams.put("client_id", "dkv-app");
        formParams.put("refresh_token", token());
        Response response = RestResource.postWithToken(formParams);

        if (response.statusCode() != 200) {
            throw new RuntimeException("ABORT! Renew token failed");
        }
        return response;
    }

    public static String getNotificationToken() {
        String access_token = null;
        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
                Response response = renewNotificationToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 30);
            } else {
                throw new RuntimeException("Token is good to use");
            }
        } catch (Exception e) {
            logger.error("Error is here" + e);
            throw new RuntimeException("ABORT! Failed to get a Notification token");
        }
        return access_token;
    }

    private static Response renewNotificationToken() {

        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "client_credentials");
        formParams.put("client_id", "gfx-cdr-collector-service-client");
        formParams.put("client_secret", secret());
        Response response = RestResource.postWithToken(formParams);

        if (response.statusCode() != 200) {
            throw new RuntimeException("ABORT! Renew notification token failed");
        }
        return response;
    }
}
