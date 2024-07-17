package org.dkv.api.model.notificationFlow.capability;

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
public class NotificationCapabilityPojo {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("userIds")
    private List<Integer> userIds;
    @JsonProperty("isNotificationCapable")
    private Boolean isNotificationCapable;
    @JsonProperty("NotificationCapableUsers")
    private Integer NotificationCapableUsers;
    @JsonProperty("status")
    private int status;
    @JsonProperty("message")
    private String message;
}
