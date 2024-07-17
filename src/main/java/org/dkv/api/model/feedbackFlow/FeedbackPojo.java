package org.dkv.api.model.feedbackFlow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.LinkedHashMap;
import java.util.Map;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedbackPojo {
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new LinkedHashMap<>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("reviewType")
    private String reviewType;
    @JsonProperty("appVersion")
    private String appVersion;
    @JsonProperty("osVersion")
    private String osVersion;
    @JsonProperty("customerNumber")
    private String customerNumber;
}
