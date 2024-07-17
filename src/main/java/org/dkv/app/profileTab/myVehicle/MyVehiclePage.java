package org.dkv.app.profileTab.myVehicle;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.resourceId;

public class MyVehiclePage {

    AppiumSelector myVehicleTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTitle")), By.id("ios"));
    AppiumSelector myVehicleBackBtn = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleBackBtn")), By.id("ios"));
    AppiumSelector notSpecifiedRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtn0")), By.id("ios"));
    AppiumSelector notSpecifiedTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnTitle0")), By.id("ios"));
    AppiumSelector notSpecifiedDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnDescription0")), By.id("ios"));
    AppiumSelector carRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtn1")), By.id("ios"));
    AppiumSelector carTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnTitle1")), By.id("ios"));
    AppiumSelector carDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnDescription1")), By.id("ios"));
    AppiumSelector truckSmallRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtn2")), By.id("ios"));
    AppiumSelector truckSmallTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnTitle2")), By.id("ios"));
    AppiumSelector truckSmallDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnDescription2")), By.id("ios"));
    AppiumSelector truckRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtn3")), By.id("ios"));
    AppiumSelector truckTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnTitle3")), By.id("ios"));
    AppiumSelector truckDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleTypeRadioBtnDescription3")), By.id("ios"));
    AppiumSelector noInformationRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtn0")), By.id("ios"));
    AppiumSelector noInformationTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnTitle0")), By.id("ios"));
    AppiumSelector noInformationDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnDescription0")), By.id("ios"));
    AppiumSelector combustionEngineRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtn1")), By.id("ios"));
    AppiumSelector combustionEngineTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnTitle1")), By.id("ios"));
    AppiumSelector combustionEngineDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnDescription1")), By.id("ios"));
    AppiumSelector preferredFuelType = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1Title0")), By.id("ios"));
    AppiumSelector preferredFuelValue = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1Value0")), By.id("ios"));
    AppiumSelector preferredFuelArrow = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1DropDown0")), By.id("ios"));
    AppiumSelector priceDisplay = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1Title1")), By.id("ios"));
    AppiumSelector priceDisplayValue = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1Value1")), By.id("ios"));
    AppiumSelector priceDisplayArrow = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector1DropDown1")), By.id("ios"));
    AppiumSelector electricRadioButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtn2")), By.id("ios"));
    AppiumSelector electricTitle = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnTitle2")), By.id("ios"));
    AppiumSelector electricDescription = new AppiumSelector(new ByAndroidUIAutomator(resourceId("driveTypeRadioBtnDescription2")), By.id("ios"));
    AppiumSelector vehicleModel = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector2Title0")), By.id("ios"));
    AppiumSelector vehicleModelValue = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector2Value0")), By.id("ios"));
    AppiumSelector vehicleModelArrow = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector2DropDown0")), By.id("ios"));
    AppiumSelector routeCharging = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector2Title1")), By.id("ios"));
    AppiumSelector routeChargingArrow = new AppiumSelector(new ByAndroidUIAutomator(resourceId("propertySelector2DropDown1")), By.id("ios"));
    AppiumSelector backButton = new AppiumSelector(new ByAndroidUIAutomator(resourceId("myVehicleBackBtn")), By.id("ios"));

    public void clickBackButton() {
        findByBy(backButton).click();
    }

    public boolean checkViewsAreNotNull() {
        return findByBy(myVehicleTitle).isDisplayed() &&
                findByBy(myVehicleBackBtn).isDisplayed() &&
                findByBy(notSpecifiedRadioButton).isDisplayed() &&
                findByBy(notSpecifiedTitle).isDisplayed() &&
                findByBy(notSpecifiedDescription).isDisplayed() &&
                findByBy(carRadioButton).isDisplayed() &&
                findByBy(carTitle).isDisplayed() &&
                findByBy(carDescription).isDisplayed() &&
                findByBy(truckSmallRadioButton).isDisplayed() &&
                findByBy(truckSmallTitle).isDisplayed() &&
                findByBy(truckSmallDescription).isDisplayed() &&
                findByBy(truckRadioButton).isDisplayed() &&
                findByBy(truckTitle).isDisplayed() &&
                findByBy(truckDescription).isDisplayed() &&
                findByBy(noInformationRadioButton).isDisplayed() &&
                findByBy(noInformationTitle).isDisplayed() &&
                findByBy(noInformationDescription).isDisplayed() &&
                findByBy(combustionEngineRadioButton).isDisplayed() &&
                findByBy(combustionEngineTitle).isDisplayed() &&
                findByBy(combustionEngineDescription).isDisplayed() &&
                findByBy(electricRadioButton).isDisplayed() &&
                findByBy(electricTitle).isDisplayed() &&
                findByBy(electricDescription).isDisplayed();
    }

    public PreferredFuelPage navigateToPreferredFuel() {
        findByBy(preferredFuelArrow).click();
        return new PreferredFuelPage();
    }

    public boolean notSpecifiedIsSelected() {
        return findByBy(notSpecifiedRadioButton).isChecked();
    }

    public boolean noInformationIsSelected() {
        return findByBy(noInformationRadioButton).isChecked();
    }

    public void clickCarRadioButton() {
        findByBy(carRadioButton).click();
    }

    public boolean carIsSelected() {
        return findByBy(carRadioButton).isChecked();
    }

    public void clickTruckSmallRadioButton() {
        findByBy(truckSmallRadioButton).click();
    }

    public boolean truckSmallIsSelected() {
        return findByBy(truckSmallRadioButton).isChecked();
    }

    public void clickTruckRadioButton() {
        findByBy(truckRadioButton).click();
    }

    public boolean truckIsSelected() {
        return findByBy(truckRadioButton).isChecked();
    }

    public void clickNoInformationRadioButton() {
        findByBy(noInformationRadioButton).click();
    }

    public void clickCombustionEngineRadioButton() {
        findByBy(combustionEngineRadioButton).click();
    }

    public boolean combustionEngineValueIsDisplayed() {
        return findByBy(preferredFuelType).isDisplayed() &&
                findByBy(preferredFuelValue).isDisplayed() &&
                findByBy(priceDisplay).isDisplayed() &&
                findByBy(priceDisplayValue).isDisplayed();
    }

    public String getFuelTypeText() {
        return findByBy(preferredFuelValue).getText();
    }

    public String getPriceDisplayText() {
        return findByBy(priceDisplayValue).getText();
    }

    public PreferredPriceDisplay clickPriceDisplayArrow() {
        findByBy(priceDisplayArrow).click();
        return new PreferredPriceDisplay();
    }

    public void clickElectricRadioButton() {
        findByBy(electricRadioButton).click();
    }

    public boolean electricVehicleIsDisplayed() {
        return findByBy(vehicleModel).isDisplayed() &&
                findByBy(vehicleModelValue).isDisplayed() &&
                findByBy(routeCharging).isDisplayed();
    }

    public String getVehicleModelText() {
        return findByBy(vehicleModelValue).getText();
    }

    public VehicleModelPage clickVehicleModelArrow() {
        findByBy(vehicleModelArrow).click();
        return new VehicleModelPage();
    }

    public RouteCharging clickRouteChargingArrow() {
        findByBy(routeChargingArrow).click();
        return new RouteCharging();
    }
}
