package org.dkv.app.profileTab.myVehicle;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.resourceId;

public class PreferredFuelPage {

    AppiumSelector preferredFuelTitle = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator(resourceId("preferredFuelTitle")), By.id("ios"));
    AppiumSelector preferredFuelBackBtn = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator(resourceId("preferredFuelBackBtn")), By.id("ios"));
    AppiumSelector bioDieselCheckBox = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator(resourceId("fuelTypeCheckbox3")), By.id("ios"));
    AppiumSelector bioDieselCheckBoxText = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator(resourceId("fuelTypeCheckboxText3")), By.id("ios"));
    AppiumSelector truckDieselCheckBox = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator(resourceId("fuelTypeCheckbox19")), By.id("ios"));

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
