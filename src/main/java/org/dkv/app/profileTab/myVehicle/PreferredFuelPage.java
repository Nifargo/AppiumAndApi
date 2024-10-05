package org.dkv.app.profileTab.myVehicle;

import common.appiumElementsSettings.AppiumSelector;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.androidJetPackLocator;

public class PreferredFuelPage {

    AppiumSelector preferredFuelTitle = new AppiumSelector(androidJetPackLocator("preferredFuelTitle"), By.id("ios"));
    AppiumSelector preferredFuelBackBtn = new AppiumSelector(androidJetPackLocator("preferredFuelBackBtn"), By.id("ios"));
    AppiumSelector bioDieselCheckBox = new AppiumSelector(androidJetPackLocator("fuelTypeCheckbox3"), By.id("ios"));
    AppiumSelector bioDieselCheckBoxText = new AppiumSelector(androidJetPackLocator("fuelTypeCheckboxText3"), By.id("ios"));
    AppiumSelector truckDieselCheckBox = new AppiumSelector(androidJetPackLocator("fuelTypeCheckbox19"), By.id("ios"));

    public String getPreferredFuelTitle() {
        return findByBy(preferredFuelTitle).getText();
    }

    public void clickBioDieselCheckBox() {
        findByBy(bioDieselCheckBox).click();
    }

    public String getBioDieselCheckBoxText() {
        return findByBy(bioDieselCheckBoxText).getText();
    }

    public void clickPreferredFuelBackBtn() {
        findByBy(preferredFuelBackBtn).click();
        new MyVehiclePage();
    }

    public void clickTruckDieselCheckBox() {
        findByBy(truckDieselCheckBox).click();
    }
}
