package org.dkv.api.model.notificationFlow.notificationFlowGuest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("topicId")
    private String topicId;
    @JsonProperty("error")
    private String error;
}
