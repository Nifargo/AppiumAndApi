package org.dkv.app.profileTab.myVehicle;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.find;
import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.WebTypeElements.APPBUTTON;
import static common.locatorsSettings.WebTypeElements.APPLISTBOX;
import static org.openqa.selenium.By.id;

public class VehicleModelPage {

    AppiumSelector mainCloseButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/close"), id("ios"));
    String brandField = getLocatorByType(APPLISTBOX, "brand-list");
    String modelField = getLocatorByType(APPLISTBOX, "model-list");
    String variantField = getLocatorByType(APPLISTBOX, "variant-list");
    String resetButton = getLocatorByType(APPBUTTON, "reset-button");
    String saveButton = getLocatorByType(APPBUTTON, "save-button");
    String audiBrand = "//li[text()=' Audi ']";
    String audiModel = "//li[text()=' e-tron ']";
    String audiVariant = "//li[text()=' S ']";


    public boolean checkViewsAreNotNull() {
        return find(brandField).isDisplayed() &&
                find(modelField).isDisplayed() &&
                find(variantField).isDisplayed() &&
                find(resetButton).isDisplayed() &&
                find(saveButton).isDisplayed();
    }

    public void clickCloseButton() {
        findByBy(mainCloseButton).click();
    }

    public void selectAudiBrand() {
        find(brandField).click();
        find(audiBrand).click();
    }

    public void clickAudiModelButton() {
        find(modelField).click();
        find(audiModel).click();
    }

    public void clickAudiVariantButton() {
        find(variantField).click();
        find(audiVariant).click();
    }

    public void clickResetButton() {
        find(resetButton).click();
    }

    public void clickSaveButton() {
        find(saveButton).click();
    }

    public String getBrandName() {
        return find(brandField).getText();
    }

    public String getModelName() {
        return find(modelField).getText();
    }

    public String getVariantName() {
        return find(variantField).getText();
    }
}
