package org.dkv.app.firstOpenJourney;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class OnboardingLinearLayout {

    AppiumSelector carButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'CAR']"), xpath("//XCUIElementTypeStaticText[@name='CAR']"));
    AppiumSelector truckSmallButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'TRUCK (small)']"), xpath("//XCUIElementTypeStaticText[@name='TRUCK (small)']"));
    AppiumSelector truckButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'TRUCK']"), xpath("//XCUIElementTypeStaticText[@name='TRUCK']"));
    AppiumSelector refuellingButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Refuelling']"), xpath("//XCUIElementTypeStaticText[@name='Refuelling']"));
    AppiumSelector chargeButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Charge']"), xpath("//XCUIElementTypeStaticText[@name='Charge']"));
    AppiumSelector vehicleTypeNextButton = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"vehicleTypeTopButton\")"), xpath("//XCUIElementTypeButton[@name='Next']"));
    AppiumSelector vehicleTypeLaterButton = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"vehicleTypeBottomButton\")"), xpath("//XCUIElementTypeButton[@name='Later']"));


    public LocationPopUp clickLaterButton() {
        findByBy(vehicleTypeLaterButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickNextButton() {
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickCarButton() {
        findByBy(carButton).click();
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickTruckSmallButton() {
        findByBy(truckSmallButton).click();
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickTruckButton() {
        findByBy(truckButton).click();
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickRefuellingButton() {
        findByBy(refuellingButton).click();
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public LocationPopUp clickChargeButton() {
        findByBy(chargeButton).click();
        findByBy(vehicleTypeNextButton).click();
        return new LocationPopUp();
    }

    public boolean isExistCarButton() {
        return findByBy(carButton).isDisplayed();
    }

    public boolean isExistTruckSmallButton() {
        return findByBy(truckSmallButton).isDisplayed();
    }

    public boolean isExistTruckButton() {
        return findByBy(truckButton).isDisplayed();
    }

    public boolean isExistRefuellingButton() {
        return findByBy(refuellingButton).isDisplayed();
    }

    public boolean isExistChargeButton() {
        return findByBy(chargeButton).isDisplayed();
    }

    public void endOnBoarding() {
        findByBy(vehicleTypeNextButton).click();
    }
}