package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.listener.TestListener;
import common.pageFinder.Finder;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.DirectionForWebScrolling.DOWN;
import static helpers.baseHelpers.DirectionForWebScrolling.UP;
import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.HelpersMethod.scrollDown;
import static helpers.baseHelpers.HelpersMethod.scrollUsingJS;

@ExtendWith(TestListener.class)
@Tag("ui")
public class MyVehicleTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T11 Check My vehicle page for guest user")
    public void openMyVehicleAndCheckViews() {

        String defFuelType = "Not specified";
        String preferredFuelTitle = "Preferred fuel type";
        String bioDieselText = "Biodiesel";
        String truckDieselText = "Truck diesel";
        String defPriceDisplayText = "Diesel";
        String nextPriceDisplayText = "Petrol";
        String defVehicleModel = "Not specified";

        var profilePage = new NavigationBar().clickProfileButton();
        var myVehiclePage = profilePage.clickMyVehicleButton();

        Assertions.assertTrue(myVehiclePage.checkViewsAreNotNull());
        Assertions.assertTrue(myVehiclePage.notSpecifiedIsSelected());
        Assertions.assertTrue(myVehiclePage.noInformationIsSelected());

        myVehiclePage.clickCarRadioButton();
        Assertions.assertTrue(myVehiclePage.carIsSelected());

        myVehiclePage.clickTruckSmallRadioButton();
        Assertions.assertTrue(myVehiclePage.truckSmallIsSelected());

        myVehiclePage.clickTruckRadioButton();
        Assertions.assertTrue(myVehiclePage.truckIsSelected());

        myVehiclePage.clickCombustionEngineRadioButton();
        Assertions.assertTrue(myVehiclePage.combustionEngineValueIsDisplayed());
        Assertions.assertEquals(defFuelType, myVehiclePage.getFuelTypeText());

        var preferredFuelPage = myVehiclePage.navigateToPreferredFuel();
        Assertions.assertEquals(preferredFuelTitle, preferredFuelPage.getPreferredFuelTitle());
        preferredFuelPage.clickBioDieselCheckBox();
        Assertions.assertEquals(bioDieselText, preferredFuelPage.getBioDieselCheckBoxText());
        preferredFuelPage.clickPreferredFuelBackBtn();
        Assertions.assertEquals(bioDieselText, myVehiclePage.getFuelTypeText());

        myVehiclePage.navigateToPreferredFuel();
        preferredFuelPage.clickTruckDieselCheckBox();
        preferredFuelPage.clickPreferredFuelBackBtn();
        Assertions.assertEquals(truckDieselText, myVehiclePage.getFuelTypeText());

        myVehiclePage.clickNoInformationRadioButton();
        myVehiclePage.clickCombustionEngineRadioButton();
        Assertions.assertEquals(defFuelType, myVehiclePage.getFuelTypeText());
        Assertions.assertEquals(defPriceDisplayText, myVehiclePage.getPriceDisplayText());

        var preferredPriceDisplay = myVehiclePage.clickPriceDisplayArrow();
        preferredPriceDisplay.clickPetrolButton();
        Assertions.assertEquals(nextPriceDisplayText, myVehiclePage.getPriceDisplayText());
        myVehiclePage.clickPriceDisplayArrow();
        preferredPriceDisplay.clickDieselButton();
        Assertions.assertEquals(defPriceDisplayText, myVehiclePage.getPriceDisplayText());

        myVehiclePage.clickNoInformationRadioButton();
        myVehiclePage.clickElectricRadioButton();

        scrollDown(0.8, 0.1, 0.5, 2000);

        Assertions.assertTrue(myVehiclePage.electricVehicleIsDisplayed());
        Assertions.assertEquals(defVehicleModel, myVehiclePage.getVehicleModelText());
        var vehicleModelPage = myVehiclePage.clickVehicleModelArrow();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();
        scrollUsingJS(DOWN);

        Assertions.assertTrue(vehicleModelPage.checkViewsAreNotNull());

        vehicleModelPage.clickSaveButton();

        handler.changeContext(ContextType.NATIVE);
        scrollDown(0.8, 0.1, 0.5, 2000);

        var routeCharging = myVehiclePage.clickRouteChargingArrow();

        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        scrollUsingJS(DOWN);

        Assertions.assertTrue(routeCharging.checkSaveButtonsIsDisplayed(true));

        routeCharging.clickSaveButton();

        handler.changeContext(ContextType.NATIVE);

        myVehiclePage.clickBackButton();
    }

    @Test
    @DisplayName("DAF-T12 Check My vehicle model page for guest user")
    public void vehiclePageActivity() {

        String defBrandName = "Brand";
        String AudiBrandName = "Audi";
        String audiModelName = "e-tron";
        String audiVariantName = "S";
        String VehicleName = "Audi e-tron S";
        String defVehicleModelName = "Not specified";

        var profilePage = new NavigationBar().clickProfileButton();
        var myVehiclePage = profilePage.clickMyVehicleButton();
        myVehiclePage.clickElectricRadioButton();

        Assertions.assertEquals(defVehicleModelName, myVehiclePage.getVehicleModelText());

        scrollDown(0.8, 0.1, 0.5, 2000);
        var vehicleModelPage = myVehiclePage.clickVehicleModelArrow();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        Assertions.assertEquals(defBrandName, vehicleModelPage.getBrandName());

        vehicleModelPage.selectAudiBrand();
        vehicleModelPage.clickSaveButton();
        Assertions.assertEquals(AudiBrandName, vehicleModelPage.getBrandName());

        vehicleModelPage.clickAudiModelButton();
        vehicleModelPage.clickSaveButton();
        Assertions.assertEquals(audiModelName, vehicleModelPage.getModelName());

        vehicleModelPage.clickAudiVariantButton();
        Assertions.assertEquals(audiVariantName, vehicleModelPage.getVariantName());

        vehicleModelPage.clickSaveButton();

        handler.changeContext(ContextType.NATIVE);

        Assertions.assertEquals(VehicleName, myVehiclePage.getVehicleModelText());

        myVehiclePage.clickVehicleModelArrow();

        handler.changeContext(ContextType.WEB);
        vehicleModelPage.clickResetButton();
        Assertions.assertEquals(defBrandName, vehicleModelPage.getBrandName());

        handler.changeContext(ContextType.NATIVE);

        vehicleModelPage.clickCloseButton();
        Assertions.assertEquals(VehicleName, myVehiclePage.getVehicleModelText());

        myVehiclePage.clickVehicleModelArrow();

        handler.changeContext(ContextType.WEB);

        vehicleModelPage.clickResetButton();
        vehicleModelPage.clickSaveButton();

        handler.changeContext(ContextType.NATIVE);

        Assertions.assertEquals(defVehicleModelName, myVehiclePage.getVehicleModelText());

        myVehiclePage.clickBackButton();
    }

    @Test
    @DisplayName("DAF-T13 Check My vehicle page - Advanced settings")
    public void advancedSettingsPage() {

        var profilePage = new NavigationBar().clickProfileButton();
        var myVehiclePage = profilePage.clickMyVehicleButton();
        myVehiclePage.clickElectricRadioButton();

        scrollDown(0.8, 0.1, 0.5, 2000);
        var routeCharging = myVehiclePage.clickRouteChargingArrow();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        routeCharging.clickFastCharging();
        pause(100);
        routeCharging.clickUltraCharging();
        pause(100);
        routeCharging.clickNormalCharging();

        Assertions.assertTrue(routeCharging.checkValidationWarningMsg(true));

        scrollUsingJS(DOWN);

        routeCharging.clickSaveButton();
        Assertions.assertTrue(routeCharging.checkSaveButtonsIsDisplayed(true));

        scrollUsingJS(UP);

        Assertions.assertFalse(routeCharging.checkValidationWarningMsg(false));

        scrollUsingJS(DOWN);

        routeCharging.clickResetButton();
        routeCharging.clickSaveButton();
        Assertions.assertFalse(routeCharging.checkSaveButtonsIsDisplayed(false));

        handler.changeContext(ContextType.NATIVE);

        myVehiclePage.clickBackButton();
    }
}
