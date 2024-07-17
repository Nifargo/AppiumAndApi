package org.dkv.api.model.cardSynchronization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardSyncPojo {

    @JsonProperty("id")
    private int id;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("cards")
    private List<CardPojo> cards;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("status")
    private int status;

    @JsonProperty("error")
    private String error;

    @JsonProperty("path")
    private String path;

    @JsonIgnore
    private Map<String, Object> additionalProperties;
}