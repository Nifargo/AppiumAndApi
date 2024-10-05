package org.dkvProject.api.bff.stationInformation;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.chargeStationInformation.ChargeStationInformationApi;
import org.dkv.api.model.chargeStationInfo.AddressInfoPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChargeStationInformationApiTests {

    @Test
    @DisplayName("Get detailed information(name) about Fuel stations based on POI's ID")
    public void testGetChargeStationInformation() {

        Response response = ChargeStationInformationApi.getChargeStationInformation("SS3475089");
        AddressInfoPojo addressInfoPojo = response.as(AddressInfoPojo.class);

        forResponseAssertion(response).statusCodeIsEqualTo(StatusCode.OK);
        assertThat(addressInfoPojo.getName(), equalTo("ARAL Station"));
    }
}
