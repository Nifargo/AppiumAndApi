package org.dkvProject.ui.loginFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.pageFinder.Finder;
import helpers.baseHelpers.SkipLoginFlowTest;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.baseHelpers.DirectionForWebScrolling.DOWN;
import static helpers.baseHelpers.DirectionForWebScrolling.UP;
import static helpers.baseHelpers.HelpersMethod.scrollDown;
import static helpers.baseHelpers.HelpersMethod.scrollUsingJS;

@Tag("ui")
public class LoginProfilePageTest extends SkipLoginFlowTest {

    @Test
    @DisplayName("DAF-T43,Check Route & Charging page for logged in user")
    public void RouteChargingPageTest() {

        var profilePage = new NavigationBar().clickProfileButton();
        var myVehiclePage = profilePage.clickMyVehicleButton();
        myVehiclePage.clickElectricRadioButton();

        scrollDown(0.8, 0.1, 0.5, 2000);
        var routeCharging = myVehiclePage.clickRouteChargingArrow();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        routeCharging.clickFastCharging();
        routeCharging.clickUltraCharging();
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

    @Test
    @DisplayName("DAF-T77, Check My vehicle page - Advanced settings")
    public void myVehicleModelServicePageTest() {

        String defBrandName = "Brand";
        String AudiBrandName = "Audi";
        String audiModelName = "e-tron";
        String audiVariantName = "S";
        String VehicleName = "Audi e-tron S";
        String defVehicleModelName = "Not specified";

        var navigationBar = new NavigationBar();
        var servicePage = navigationBar.clickServiceButton();

        var profilePage = navigationBar.clickProfileButton();
//        TODO add checking vehicle model on the service page
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

        myVehiclePage.clickBackButton();

        navigationBar.clickServiceButton();

//        TODO add checking vehicle model on the service page

    }
}
