package org.dkvProject.api.cardSynchronization;

import io.restassured.response.Response;
import org.dkv.api.controller.cardSynchronization.CardSynchronizationApi;
import org.dkv.api.model.cardSynchronization.CardPojo;
import org.dkv.api.model.cardSynchronization.CardSyncPojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.dkv.api.common.helpers.BaseMethods.assertStatusCode;
import static org.dkv.api.controller.cardSynchronization.CardSyncYmlReader.getSyncCard;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Tag("api")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CardSynchronizationApiTest {

    @Test
    @DisplayName("Check if DKV card in the wallet has been synchronized")
    public void testCardSynchronization() {

        Response response = CardSynchronizationApi.postCardSynchronization();
        CardSyncPojo cardSyncResponse = response.as(CardSyncPojo.class);
        assertStatusCode(response.statusCode(), 200);
        CardPojo firstCardPojo = cardSyncResponse.getCards().get(0);
        CardPojo secondCardPojo = cardSyncResponse.getCards().get(1);
        CardPojo cardFirst = getSyncCard().get(0);
        CardPojo secondFirst = getSyncCard().get(1);
        assertThat(firstCardPojo.getId(), equalTo(cardFirst.getId()));
        assertThat(secondCardPojo.getId(), equalTo(secondFirst.getId()));
    }

    @Test
    @DisplayName("Check if DKV card in the wallet has been synchronized one time")
    public void testCardSynchronizationOneTime() {

        Response response = CardSynchronizationApi.postCardSynchronizationOneTime();
        CardSyncPojo cardSyncResponse = response.as(CardSyncPojo.class);
        assertStatusCode(response.statusCode(), 200);
        assertThat(cardSyncResponse.getId(), equalTo(512701));
        assertThat(cardSyncResponse.getUpdatedAt(), notNullValue());
    }

    @Test
    @DisplayName("Check if DKV card in the wallet when we dont send users id")
    public void testIncorrectCardSynchronization() {

        Response response = CardSynchronizationApi.incorrectCardSynchronizationGet();
        CardSyncPojo cardSyncResponse = response.as(CardSyncPojo.class);
        assertStatusCode(response.statusCode(), 404);
        assertThat(cardSyncResponse.getError(), equalTo("Not Found"));
        assertThat(cardSyncResponse.getPath(), equalTo("/v1/gfx/driver/card-sync"));
    }
}
