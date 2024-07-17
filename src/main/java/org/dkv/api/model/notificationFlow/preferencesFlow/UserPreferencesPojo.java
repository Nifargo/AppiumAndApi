package org.dkv.api.model.notificationFlow.preferencesFlow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPreferencesPojo {

    @JsonProperty("preferences")
    private List<String> preferences;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;
}
