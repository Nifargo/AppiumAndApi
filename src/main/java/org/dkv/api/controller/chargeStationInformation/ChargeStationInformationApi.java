package org.dkv.api.controller.chargeStationInformation;
import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlBffService;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlChargeStationInformation;

public class ChargeStationInformationApi {

    public static Response getChargeStationInformation(String StationId) {
        return RestResource.get(baseUrl() + baseUrlBffService() +baseUrlChargeStationInformation() + StationId);
    }
}
