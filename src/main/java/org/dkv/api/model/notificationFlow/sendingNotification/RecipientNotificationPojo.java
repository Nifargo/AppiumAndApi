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
public class RecipientNotificationPojo {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("token")
    private String token;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("notification")
    private NotificationBodyPojo notification;
    @JsonProperty("data")
    private SendingNotificationDataPojo data;

    @JsonIgnore
    private Map<String, Object> additionalProperties;
}
