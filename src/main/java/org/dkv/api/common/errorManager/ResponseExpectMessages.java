package org.dkv.api.common.errorManager;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class ResponseExpectMessages {

    private final Response targetResponse;

    public static ResponseExpectMessages forResponseStatusMessage(Response response) {
        return new ResponseExpectMessages(response);
    }

    public String expectedStatusCode(StatusCode expectedStatusCode) {
        return "\u001B[32m \nExpected status code: \u001B[0m" + expectedStatusCode.name() + " " + expectedStatusCode.code + "\n" +
                "\u001B[32mActual status code: \u001B[0m" + StatusCode.byValue(targetResponse.statusCode()).name() + " " + targetResponse.statusCode() + "\n" +
                "\u001B[34mActual response body:\n \u001B[0m" + targetResponse.body().asString() + "\n";
    }

    public String verifyResponseBodyType(Class expectedClass) {
        Field[] fields = expectedClass.getDeclaredFields();

        List<String> fieldNames = Arrays.stream(fields)
                .map(Field::getName)
                .toList();

        return "\u001B[32m\nUnexpected response body:\n\u001B[0m" + targetResponse.asString() + "\n" +
                "\u001B[32mExpected body type: \u001B[0m" + expectedClass.getSimpleName() + "\n" +
                "\u001B[34mWith fields:\n \u001B[0m" + fieldNames + "\n";
    }
}
