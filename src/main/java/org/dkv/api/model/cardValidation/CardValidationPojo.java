package org.dkv.api.model.cardValidation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardValidationPojo {

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new LinkedHashMap<>();
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("customerNumber")
    private String customerNumber;
    @JsonProperty("cardValidTo")
    private String cardValidTo;
    @JsonProperty("localizationKey")
    private LocalizationKeyPojo localizationKey;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("status")
    private String status;
    @JsonProperty("error")
    private String error;
    @JsonProperty("message")
    private String message;
    @JsonProperty("networks")
    private List<String> networks;
}