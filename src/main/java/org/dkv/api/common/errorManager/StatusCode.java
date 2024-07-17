package org.dkv.api.common.errorManager;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public enum StatusCode {
    CREATED(201), OK(200), ACCEPTED(202), NO_CONTENT(204),
    REDIRECT(302),
    BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), NOT_FOUND(404), PROXY_AUTH_REQUIRED(407), CONFLICT(409), TOO_LARGE(413),
    SERVER_ERROR(500), SERVICE_UNAVAILABLE(503), GATEWAY_TIMEOUT(504);

    public final int code;

    public static StatusCode byValue(int value) {
        return Stream.of(StatusCode.values())
                .filter(code -> code.code == value)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such status code known: " + value));
    }
}
