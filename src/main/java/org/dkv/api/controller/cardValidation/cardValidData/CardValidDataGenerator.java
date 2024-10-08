package org.dkv.api.controller.cardValidation.cardValidData;

import java.util.stream.Stream;

import static org.dkv.api.controller.cardValidation.CardValidationApi.formatExpirationDate;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvCardId;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvCustomerId;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvExpiredDate;
import static org.dkv.api.controller.cardValidation.NovofleetYmlReader.novoCardId;
import static org.dkv.api.controller.cardValidation.NovofleetYmlReader.novoCustomerId;
import static org.dkv.api.controller.cardValidation.NovofleetYmlReader.novoExpiredDate;

@SuppressWarnings("unused")
public class CardValidDataGenerator {

    @SuppressWarnings("unused")
    static Stream<Object[]> cardValidData() {
        return Stream.of(
                new Object[]{dkvCardId(), dkvCustomerId(), formatExpirationDate(dkvExpiredDate())},
                new Object[]{novoCardId(), novoCustomerId(), formatExpirationDate(novoExpiredDate())}
        );
    }

    @SuppressWarnings("unused")
    static Stream<Object[]> cardInvalidData() {
        return Stream.of(
                new Object[]{"123123123", novoCustomerId(), formatExpirationDate(novoExpiredDate())},
                new Object[]{novoCardId(), novoCustomerId(), formatExpirationDate("0811")}
        );
    }

    @SuppressWarnings("unused")
    static Stream<Object[]> cardWithoutData() {
        return Stream.of(
                new Object[]{dkvCardId(), null, null},
                new Object[]{novoCardId(), novoCustomerId(), null}
        );
    }
}
