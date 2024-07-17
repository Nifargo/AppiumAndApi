package org.dkv.api.controller.cardSynchronization;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlCardSync;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlIncorrectCardSync;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.cardSyncOneTime;

public class CardSynchronizationApi {

    public static Response postCardSynchronization() {
        return RestResource.post(baseUrl() + baseUrlCardSync(), "");
    }

    public static Response postCardSynchronizationOneTime() {
        return RestResource.post(baseUrl() + baseUrlCardSync() + cardSyncOneTime(), "");
    }

    public static Response incorrectCardSynchronizationGet() {
        return RestResource.post(baseUrl() + baseUrlIncorrectCardSync(), "");
    }
}
