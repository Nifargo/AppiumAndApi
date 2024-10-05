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
public class AddressInfoPojo {

	@JsonProperty("zipCode")
	private String zipCode;

	@JsonProperty("country")
	private String country;

	@JsonProperty("featureGroups")
	private List<FeatureGroupsItemPojo> featureGroups;

	@JsonProperty("city")
	private String city;

	@JsonProperty("street")
	private String street;

	@JsonProperty("name")
	private String name;

	@JsonProperty("location")
	private LocationPojo location;

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("networks")
	private List<String> networks;

	@JsonProperty("brand")
	private String brand;
}