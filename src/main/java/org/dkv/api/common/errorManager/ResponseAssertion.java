package org.dkv.api.common.errorManager;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;

@AllArgsConstructor
public class ResponseAssertion {

    private final Response targetResponse;

    public static ResponseAssertion forResponseAssertion(Response response) {
        return new ResponseAssertion(response);
    }

    public ResponseAssertion statusCodeIsEqualTo(StatusCode expectedStatusCode) {
        var statusCodeAssertionMessage = new ResponseExpectMessages(targetResponse)
                .expectedStatusCode(expectedStatusCode);

        Assertions.assertThat(targetResponse.statusCode())
                .withFailMessage(statusCodeAssertionMessage)
                .isEqualTo(expectedStatusCode.code);
        return this;
    }

    public void responseIsEmpty() {
        Assertions.assertThat(targetResponse.asString()).isEmpty();
    }

    public void responseIsEmptyArray() {
        Assertions.assertThat(targetResponse.asString()).isEqualTo("[]");
    }
}