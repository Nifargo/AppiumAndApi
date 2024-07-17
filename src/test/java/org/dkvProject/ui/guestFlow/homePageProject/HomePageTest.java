package org.dkvProject.ui.guestFlow.homePageProject;

import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.homeTab.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.scrollDown;

@Tag("ui")
public class HomePageTest extends SkipOnBoardingTest {

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
        emergencyPage.clickServiceHotline();
        navigateBackMultipleTimes(3);
        Assertions.assertTrue(emergencyPage.visibilityEmergencyNumbersTitle());
        navigateBackMultipleTimes(1);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);
//        TODO create the rest of the test after adding ids
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
        scrollDown(0.8, 0.1, 0.5, 2000);
        Assertions.assertTrue(homePage.visibilityAppBanner());
    }

    @Test
    @DisplayName("DAF- Check if Notification permission banner is displayed on the home page")
    public void notificationPermissionBanner() {

        var homePage = new HomePage();
        scrollDown(0.8, 0.1, 0.5, 2000);
        Assertions.assertTrue(homePage.visibilityNotificationPermission());
    }
}
