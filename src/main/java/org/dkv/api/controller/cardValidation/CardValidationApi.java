package org.dkv.api.controller.cardValidation;

import io.restassured.response.Response;
import org.dkv.api.common.applicationBaseRestResource.RestResource;
import org.dkv.api.model.cardValidation.CardValidationPojo;

import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrl;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.baseUrlBffService;
import static org.dkv.api.common.baseUrlManager.baseUrlYmlReader.cardValidate;

public class CardValidationApi {
    public static Response cardValidationGet(CardValidationPojo cardValidationPojo) {
        return RestResource.getWithParams(baseUrl() + baseUrlBffService() + cardValidate(), cardValidationPojo, "X_API_KEY_cardvalidation_dev_prod");
    }

    public static String formatExpirationDate(String Date) {
        return Date.substring(0, 2) + "." + Date.substring(2);
    }

    public CardValidationPojo getCardValidationDataPojo(String cardNumber, String customerNumber, String cardValidTo) {
        return CardValidationPojo.builder().
                cardNumber(cardNumber).
                customerNumber(customerNumber).
                cardValidTo(cardValidTo).
                build();
    }
}
