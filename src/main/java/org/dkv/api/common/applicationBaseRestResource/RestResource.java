package org.dkv.api.common.applicationBaseRestResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.dkv.api.common.baseSpec.SpecBuilderPage.getAccountRequestSpec;
import static org.dkv.api.common.baseSpec.SpecBuilderPage.getRequestSpec;
import static org.dkv.api.common.baseSpec.SpecBuilderPage.getResponseSpec;
import static org.dkv.api.common.tokenManager.TokenManager.getNotificationToken;
import static org.dkv.api.common.tokenManager.TokenManager.getToken;
import static org.dkv.api.common.xApiKeyManager.XApiKeyRunner.getApiKey;

public class RestResource {

    public static Response post(String url, Object request) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getToken()).
                body(request).
                relaxedHTTPSValidation().
                when().post(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postWithNotificationToken(String url, Object request) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getNotificationToken()).
                body(request).
                relaxedHTTPSValidation().
                when().post(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postWithXApiKey(String url, Object request, String key) {

        return given(getRequestSpec()).
                header("X-API-KEY", getApiKey(key)).
                body(request).
                relaxedHTTPSValidation().
                when().post(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postWithToken(HashMap<String, String> formParams) {

        return given(getAccountRequestSpec()).
                relaxedHTTPSValidation().
                formParams(formParams).
                when().post("/auth/realms/dkv/protocol/openid-connect/token").
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getWithParams(String url, Object params) {

        ObjectMapper objectMapper = new ObjectMapper();

        MapType mapType = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, String.class);

        Map<String, String> cardParams = objectMapper.convertValue(params, mapType);

        return given(getRequestSpec()).
                params(cardParams).
                relaxedHTTPSValidation().
                when().get(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String url, String key) {

        return given(getRequestSpec()).
                header("X-API-KEY", getApiKey(key)).
                relaxedHTTPSValidation().
                when().get(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getWithToken(String url) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getToken()).
                relaxedHTTPSValidation().
                when().get(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getWithNotificationToken(String url) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getNotificationToken()).
                relaxedHTTPSValidation().
                when().get(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response updateWithApiKey(String url, Object request, String key) {

        return given(getRequestSpec()).
                header("X-API-KEY", getApiKey(key)).
                header("Authorization", "Bearer " + getToken()).
                relaxedHTTPSValidation().
                body(request).
                when().put(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String url, Object request) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getToken()).
                relaxedHTTPSValidation().
                body(request).
                when().put(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }


    public static Response deleteWithApiKey(String url, String key) {

        return given(getRequestSpec()).
                header("X-API-KEY", getApiKey(key)).
                relaxedHTTPSValidation().
                when().delete(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response delete(String url) {

        return given(getRequestSpec()).
                header("Authorization", "Bearer " + getToken()).
                relaxedHTTPSValidation().
                when().delete(url).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
