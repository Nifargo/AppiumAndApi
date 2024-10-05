package org.dkvProject.ui.guestFlow.homePageProject;

import common.listener.TestListener;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.homeTab.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.resetApp;
import static helpers.baseHelpers.HelpersMethod.scrollDown;

@ExtendWith(TestListener.class)
@Tag("ui")
public class HomePageTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T18 Check if DKV News page is displayed")
    public void FiltersTest() {

        String expectedDkvNewsTitle = "DKV News";
        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();
        scrollDown(0.8, 0, 0.5, 2000);
        homePage.clickDkvNewsButton();
        Assertions.assertEquals(homePage.getDkvNewsTitleText(), expectedDkvNewsTitle);
        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);

    }

    @Test
    @DisplayName("DAF-T18 Check if DKV News page is displayed")
    public void DkvNewsPageTest() {

        String expectedDkvNewsTitle = "DKV News";
        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();

        scrollDown(0.8, 0, 0.5, 2000);
        homePage.clickDkvNewsButton();
        Assertions.assertEquals(homePage.getDkvNewsTitleText(), expectedDkvNewsTitle);
        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
    }

    @Test
    @DisplayName("DAF-T19 Check if My DKV cards page is empty for guest users")
    public void MyDkvCardsPage() {

        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();
        scrollDown(0.8, 0, 0.5, 2000);
        var myDkvCardsPage = homePage.clickMyDkvCardsButton();
        Assertions.assertTrue(myDkvCardsPage.emptyMyDkvCardsPage());
        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
    }

    @Test
    @DisplayName("DAF-T75 Check if Emergency numbers page is displayed after clicking in the menu")
    public void EmergencyNumbersMenuPage() {

        String expectedEmergencyTitle = "Emergency numbers";
        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();
        scrollDown(0.9, 0, 0.5, 2000);
        var emergencyPage = homePage.clickEmergencyNumbersMenuButton();
        Assertions.assertEquals(emergencyPage.getEmergencyTitleText(), expectedEmergencyTitle);
        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
    }

    @Test
    @DisplayName("DAF-T17 Check if Emergency numbers page after clicking on the emergency number button")
    public void EmergencyNumbersPage() {

        String expectedEmergencyTitle = "Emergency numbers";
        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();
        var emergencyPage = homePage.clickEmergencyButton();
        Assertions.assertEquals(emergencyPage.getEmergencyTitleText(), expectedEmergencyTitle);
        emergencyPage.clickCallButtonByIndex(0);
        Assertions.assertTrue(emergencyPage.visibilityCallButton());
        navigateBackMultipleTimes(3);
        emergencyPage.clickCallButtonByIndex(1);
        Assertions.assertTrue(emergencyPage.visibilityCallButton());
        navigateBackMultipleTimes(3);
        emergencyPage.clickCallButtonByIndex(2);
        Assertions.assertTrue(emergencyPage.visibilityCallButton());
        navigateBackMultipleTimes(3);
        emergencyPage.clickDropDownPerCountryButton();
        emergencyPage.clickAndorraNumberButton();
        Assertions.assertTrue(emergencyPage.visibilityCallButton());
        navigateBackMultipleTimes(3);
        Assertions.assertTrue(emergencyPage.visibilityEmergencyNumbersTitle());

        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
    }

    @Test
    @DisplayName("DAF-T16 Check if main picture is displayed on home page")
    public void WelcomeHomeTitle() {

        String expectedWelcomeHomeTitle = "Welcome back";

        var homePage = new HomePage();
        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
    }

    @Test
    @DisplayName("DAF-T21 Check Im my area section is displayed")
    public void InMyArea() {

        var homePage = new HomePage();
        scrollDown(0.9, 0, 0.5, 2000);
        Assertions.assertTrue(homePage.visibilityInMyAreaSection());
        Assertions.assertTrue(homePage.visibilityInMyAreaUpdateButton());
    }

    @Test
    @DisplayName("DAF- Check if appBanner is displayed on the home page")
    public void appBanner() {

        var homePage = new HomePage();
        scrollDown(0.8, 0.5, 0.5, 2000);
        Assertions.assertTrue(homePage.visibilityAppBanner());
    }

    //TODO Enabled all test when Android team will fix the issue with the notification banner

    @Test
    @DisplayName("DAF- Check if Notification permission banner is displayed on the home page")
    public void notificationPermissionBanner() {

        var homePage = new HomePage();
        Assertions.assertTrue(homePage.visibilityNotificationBanner());
    }

    @Test
    @DisplayName("DAF-95 Check if Notification banner is not displayed on the home page after closing it with x button")
    public void closeNotificationBanner() {

        var homePage = new HomePage();
        Assertions.assertTrue(homePage.visibilityNotificationBanner());
        homePage.clickCloseNotificationBanner();
        Assertions.assertFalse(homePage.visibilityNotificationBanner());

        resetApp();
    }

    @Test
    @DisplayName("DAF-93 Check if title of the notification banner is changed after clicking on the enable button")
    public void enableNotificationBanner() {

        String defaultNotificationBannerTitle = "Enable notifications";
        String enableNotificationBannerTitle = "Notifications enabled";

        var homePage = new HomePage();

        Assertions.assertEquals(defaultNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        var permissionPopUp = homePage.clickEnableNotificationBtn();
        permissionPopUp.clickPermissionAllowButton();
        Assertions.assertEquals(enableNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        resetApp();
    }

    @Test
    @DisplayName("DAF-93 Check if title of the notification banner is changed after clicking on the disabled button")
    public void disableNotificationBanner() {

        String defaultNotificationBannerTitle = "Enable notifications";
        String disableNotificationBannerTitle = "Notifications disabled";

        var homePage = new HomePage();
        Assertions.assertEquals(defaultNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        homePage.clickDisableNotificationsBtn();

        Assertions.assertEquals(disableNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        resetApp();
    }

    @Test
    @DisplayName("DAF-95 Check if Notification banner is displayed on the home page after closing it with close this message button")
    public void closeNotificationBannerWithCloseButton() {

        String defaultNotificationBannerTitle = "Enable notifications";
        String disableNotificationBannerTitle = "Notifications disabled";

        var homePage = new HomePage();
        Assertions.assertEquals(defaultNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        homePage.clickDisableNotificationsBtn();

        Assertions.assertEquals(disableNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        homePage.clickCloseMsgButton();

        Assertions.assertFalse(homePage.visibilityNotificationBanner());

        resetApp();
    }

    @Test
    @DisplayName("DAF-93 Check if title of the notification banner is changed after clicking on the enable button and disable if from the system pop-up")
    public void disableNotificationBannerOtherWay() {

        String defaultNotificationBannerTitle = "Enable notifications";
        String disableNotificationBannerTitle = "Notifications disabled";

        var homePage = new HomePage();
        Assertions.assertEquals(defaultNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        var permissionPopUp = homePage.clickEnableNotificationBtn();
        permissionPopUp.clickPermissionDenyButton();
        Assertions.assertEquals(disableNotificationBannerTitle, homePage.getNotificationBannerTitleText());

        resetApp();
    }

    @Test
    @DisplayName("DAF- Check if show on the map buttons are displayed on the home page")
    public void showOnTheMapButtons() {

        var homePage = new HomePage();
        scrollDown(0.9, 0, 0.5, 2000);
        Assertions.assertTrue(homePage.visibilityShowOnMapSection());
    }
}
