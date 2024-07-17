package org.dkv.api.model.notificationFlow.sendingNotification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendingNotificationDataPojo {

    @JsonProperty("destination")
    private String destination;
    @JsonProperty("charge_session_id")
    private String charge_session_id;

    @JsonIgnore
    private Map<String, Object> additionalProperties;
}
