package org.dkv.api.model.notificationFlow.notificationFlowGuest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationAppTokensVerifyPojo {
    @JsonProperty("tokenId")
    private String tokenId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
}
