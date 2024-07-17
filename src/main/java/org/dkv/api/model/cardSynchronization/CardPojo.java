package org.dkv.api.model.cardSynchronization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardPojo {

    @JsonProperty("emaid")
    private String emaid;
    @JsonProperty("id")
    private String id;
    @JsonProperty("pan")
    private String pan;
}