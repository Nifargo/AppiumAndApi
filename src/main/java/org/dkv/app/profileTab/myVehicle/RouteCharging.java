package org.dkv.app.profileTab.myVehicle;

import static common.appiumElementsSettings.AppiumActions.find;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.WebTypeElements.APPBUTTON;
import static common.locatorsSettings.WebTypeElements.APPCHECKBOX;
import static common.locatorsSettings.WebTypeElements.APPVALIDATION;
import static common.locatorsSettings.WebTypeElements.BUTTON;

public class RouteCharging {

    String saveButton = getLocatorByType(APPBUTTON, "save-button");
    String resetButton = getLocatorByType(BUTTON, "reset-button");
    String normalCharging = getLocatorByType(APPCHECKBOX, "normal-charging-checkbox");
    String fastCharging = getLocatorByType(APPCHECKBOX, "fast-charging-checkbox");
    String ultraCharging = getLocatorByType(APPCHECKBOX, "ultra-fast-charging-checkbox");
    String validationWarningMsg = getLocatorByType(APPVALIDATION, "validation-warning");

    public void clickSaveButton() {
        find(saveButton).click();
    }

    public boolean checkSaveButtonsIsDisplayed(boolean expected) {
        return find(saveButton).isDisplayed() == expected;
    }

    public void clickResetButton() {
        find(resetButton).click();
    }

    public void clickNormalCharging() {
        find(normalCharging).click();
    }

    public void clickFastCharging() {
        find(fastCharging).click();
    }

    public void clickUltraCharging() {
        find(ultraCharging).click();
    }

    public boolean checkValidationWarningMsg(boolean expectedVisibility) {
        return find(validationWarningMsg).isDisplayed() == expectedVisibility;
    }
}
