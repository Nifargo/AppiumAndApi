package org.dkvProject.api.cardValidationFlow;

import io.restassured.response.Response;
import org.dkv.api.common.errorManager.StatusCode;
import org.dkv.api.controller.cardValidation.CardValidationApi;
import org.dkv.api.model.cardValidation.CardValidationPojo;
import org.dkv.api.model.cardValidation.LocalizationKeyPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.dkv.api.common.errorManager.ResponseAssertion.forResponseAssertion;
import static org.dkv.api.common.errorManager.ResponseExpectMessages.forResponseStatusMessage;
import static org.dkv.api.common.helpers.BaseMethods.assertStatusCode;
import static org.dkv.api.controller.cardValidation.CardValidationApi.formatExpirationDate;
import static org.dkv.api.controller.cardValidation.NovofleetYmlReader.novoCardId;
import static org.dkv.api.controller.cardValidation.NovofleetYmlReader.novoExpiredDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardValidationApiTests {

    @ParameterizedTest
    @MethodSource("org.dkv.api.controller.cardValidation.cardValidData.CardValidDataGenerator#cardValidData")
    @DisplayName("Check if the DKV/novofleet cards are valid by card number")
    public void testDkvCardValidationValid(String cardNumber, String customerNumber, String cardValidTo) {

        var cardValidationPojo = new CardValidationApi().getCardValidationDataPojo(cardNumber, customerNumber, cardValidTo);

        Response responseCardValidation = CardValidationApi.cardValidationGet(cardValidationPojo);
        CardValidationPojo cardValidationResponse = responseCardValidation.as(CardValidationPojo.class);

        forResponseAssertion(responseCardValidation).statusCodeIsEqualTo(StatusCode.OK);
        forResponseStatusMessage(responseCardValidation).verifyResponseBodyType(CardValidationPojo.class);
        assertThat(cardValidationResponse.getCardNumber(), equalTo(cardNumber));
        assertThat(cardValidationResponse.getCustomerNumber(), equalTo(customerNumber));
        assertThat(cardValidationResponse.getCardValidTo(), equalTo(cardValidTo));
    }

    @ParameterizedTest
    @MethodSource("org.dkv.api.controller.cardValidation.cardValidData.CardValidDataGenerator#cardInvalidData")
    @DisplayName("Check if user can validate card but without some parameters")
    public void testDkvCardValidationCardNumberOnly(String cardNumber, String customerNumber, String cardValidTo) {

        var cardValidationPojo = new CardValidationApi().getCardValidationDataPojo(cardNumber, customerNumber, cardValidTo);

        Response responseCardValidation = CardValidationApi.cardValidationGet(cardValidationPojo);

        forResponseAssertion(responseCardValidation).statusCodeIsEqualTo(StatusCode.BAD_REQUEST);
    }

    @Test
    @DisplayName("Check if user can validate incorrect customer number")
    public void testDkvCardValidationCustomerNumberIncorrect() {

        var cardValidationPojo = new CardValidationApi().getCardValidationDataPojo(novoCardId(), "1233123123",
                formatExpirationDate(novoExpiredDate()));

        Response response = CardValidationApi.cardValidationGet(cardValidationPojo);

        assertStatusCode(response.statusCode(), 404);
        CardValidationPojo cardValidationResponse = response.as(CardValidationPojo.class);
        LocalizationKeyPojo localizationKey = cardValidationResponse.getLocalizationKey();
        assertThat(localizationKey.getMessage(), equalTo("pricing_pro_card_scan_failure_text"));
        assertThat(localizationKey.getTitle(), equalTo("pricing_pro_card_scan_failure_title"));
    }
}
