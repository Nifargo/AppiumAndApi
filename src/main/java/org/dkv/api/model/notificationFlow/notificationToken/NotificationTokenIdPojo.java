package org.dkv.api.model.notificationFlow.notificationToken;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationTokenIdPojo {

    @JsonProperty("token")
    private String token;
    @JsonProperty("tokenId")
    private String tokenId;
    @JsonProperty("operatingSystem")
    private String operatingSystem;
    @JsonProperty("appVersion")
    private String appVersion;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
}