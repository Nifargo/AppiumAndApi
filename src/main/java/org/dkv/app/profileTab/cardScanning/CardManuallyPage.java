package org.dkv.app.profileTab.cardScanning;

import org.dkv.app.mapTab.MapPage;

import static common.appiumElementsSettings.AppiumActions.findByDataId;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.WebTypeElements.APPBUTTON;
import static common.locatorsSettings.WebTypeElements.INPUT;

public class CardManuallyPage {

    String cardId = getLocatorByType(INPUT, "cardId");
    String customerNumber = getLocatorByType(INPUT, "customerId");
    String expirationDate = getLocatorByType(INPUT, "expiryDate");
    String confirmButton = getLocatorByType(APPBUTTON, "confirmButton");

    public void enterCardId(String text) {
        findByDataId(cardId).click();
        findByDataId(cardId).sendKeys(text);
    }

    public void enterCustomerNumber(String text) {
        findByDataId(customerNumber).click();
        findByDataId(customerNumber).sendKeys(text);
    }

    public void enterExpirationDate(String text) {
        findByDataId(this.expirationDate).click();
        findByDataId(this.expirationDate).sendKeys(text);
    }

    public MapPage clickConfirmButton() {
        findByDataId(confirmButton).click();
        return new MapPage();
    }

}
