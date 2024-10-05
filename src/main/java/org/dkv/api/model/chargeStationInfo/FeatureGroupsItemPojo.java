package org.dkv.api.model.chargeStationInfo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


@Builder
@Data
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeatureGroupsItemPojo {
	@JsonProperty("features")
	private List<String> features;

	@JsonProperty("group")
	private String group;
}