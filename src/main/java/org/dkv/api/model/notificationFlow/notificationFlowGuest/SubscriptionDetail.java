package org.dkv.api.model.notificationFlow.notificationFlowGuest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionDetail {
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("successCount")
    private int successCount;
    @JsonProperty("failureCount")
    private int failureCount;
    @JsonProperty("results")
    private List<Result> results;
}
