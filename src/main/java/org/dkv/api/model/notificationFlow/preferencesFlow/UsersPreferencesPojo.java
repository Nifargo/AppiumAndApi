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
public class UsersPreferencesPojo {

    @JsonProperty("userIds")
    private List<Integer> userIds;
    @JsonProperty("userPreferences")
    private List<UserPreferencesPojo> userPreferences;
}
