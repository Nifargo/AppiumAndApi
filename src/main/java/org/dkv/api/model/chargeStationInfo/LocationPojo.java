package org.dkv.api.model.chargeStationInfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationPojo {

	@JsonProperty("lon")
	private double lon;

	@JsonProperty("lat")
	private double lat;
}