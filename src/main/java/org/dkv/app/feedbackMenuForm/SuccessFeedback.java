package org.dkv.app.feedbackMenuForm;

import org.dkv.app.homeTab.HomePage;

import static common.appiumElementsSettings.AppiumActions.findByDataId;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.WebTypeElements.BUTTON;
import static common.locatorsSettings.WebTypeElements.SPAN;

public class SuccessFeedback {

    String closeButton = getLocatorByType(BUTTON, "closeButton");
    String successFinalText = getLocatorByType(SPAN, "successTitle");

    public String getSuccessFinalText() {
        return findByDataId(successFinalText).getText();
    }

    public HomePage clickCloseButton() {
        findByDataId(closeButton).click();
        return new HomePage();
    }
}
