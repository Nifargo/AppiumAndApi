package org.dkv.api.model.notificationFlow.notificationFlowGuest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionTopicsPojo {

    @JsonProperty("subscribed")
    private SubscriptionDetail subscribed;
    @JsonProperty("unsubscribed")
    private SubscriptionDetail unsubscribed;
    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;

}
