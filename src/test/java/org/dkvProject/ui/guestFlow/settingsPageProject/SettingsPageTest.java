package org.dkvProject.ui.guestFlow.settingsPageProject;

import common.listener.TestListener;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.HelpersMethod.scrollDown;

@ExtendWith(TestListener.class)
@Tag("ui")
public class SettingsPageTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T5,Check on the settings page - imprint is displayed")
    public void SettingsImprintTest() {

        var navigationBar = new NavigationBar();
        navigationBar.clickProfileButton();
        var settingsPage = navigationBar.clickSettingsButton();
        pause(100);
        scrollDown(0.8, 0.1, 0.5, 2000);

        Assertions.assertTrue(settingsPage.existsImprintButton());
        var additionalHeader = settingsPage.clickImprintMenuButton();
        Assertions.assertTrue(additionalHeader.getImprintTitleText());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Check on the settings page - FAQ page is displayed")
    public void SettingsFaqTest() {

        var navigationBar = new NavigationBar();
        navigationBar.clickProfileButton();
        var settingsPage = navigationBar.clickSettingsButton();
        pause(100);
        scrollDown(0.9, 0.1, 0.5, 2000);

        Assertions.assertTrue(settingsPage.existsFaqButton());
        var additionalHeader = settingsPage.clickFaqsMenuButton();
        Assertions.assertTrue(additionalHeader.getFaqTitleText());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Check if Data Protection Page is displayed")
    public void SettingsDataProtectionTest() {

        var navigationBar = new NavigationBar();
        navigationBar.clickProfileButton();
        var settingsPage = navigationBar.clickSettingsButton();
        pause(100);
        scrollDown(0.9, 0.1, 0.5, 2000);

        var additionalHeader = settingsPage.clickDataProtectMenuButton();
        Assertions.assertTrue(additionalHeader.getDataProtectionTitleText());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("DAF-90 Check on the settings page - OnboardingFlow page is displayed")
    public void SettingsOnboardingFlowTest() throws Exception {
        String expectLoginButton = "Log in";
        String expectContinueButton = "Continue without Login";

        var navigationBar = new NavigationBar();
        navigationBar.clickProfileButton();
        var settingsPage = navigationBar.clickSettingsButton();
        pause(100);
        scrollDown(0.8, 0.1, 0.5, 2000);

        settingsPage.clickOnboardingButton();
        var onboardingPage = new OnboardingPage();
        Assertions.assertTrue(onboardingPage.existsSkipButton());
        onboardingPage.clickNextButtonMultipleTimes(4);
        Assertions.assertEquals(onboardingPage.getLoginButtonText(), expectLoginButton);
        Assertions.assertEquals(onboardingPage.getContinueButtonText(), expectContinueButton);
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("DAF-T42,Check on the settings page - Price page")
    public void SettingsPriceTest() {
        String expectedPricesTitle = "Prices & currency (fuelling)";

        var navigationBar = new NavigationBar();
        navigationBar.clickProfileButton();
        var settingsPage = navigationBar.clickSettingsButton();
        var pricesCurrencyPage = settingsPage.clickPricesCurrencyButton();
        Assertions.assertEquals(pricesCurrencyPage.getPricesCurrencyTitle(), expectedPricesTitle);
        navigateBackMultipleTimes(1);
//   TODO finish this tests after adding new ids
    }

    @Test
    @DisplayName("DAF-T4, Check Settings page is not changed after clicking any radio button in the appearance section")
    public void SettingsAppearanceTest() {
        String expectedSettingsTitle = "App settings";

        var settingsPage = new NavigationBar().clickSettingsButton();
        Assertions.assertEquals(settingsPage.getAppSettingsTitle(), expectedSettingsTitle);
        settingsPage.clickLightButton();
        Assertions.assertTrue(settingsPage.lightButtonIsChecked());
        Assertions.assertEquals(settingsPage.getAppSettingsTitle(), expectedSettingsTitle);
        settingsPage.clickDarkButton();
        Assertions.assertTrue(settingsPage.darkButtonIsChecked());
        Assertions.assertEquals(settingsPage.getAppSettingsTitle(), expectedSettingsTitle);
        settingsPage.clickSystemButton();
        Assertions.assertTrue(settingsPage.systemButtonIsChecked());
        Assertions.assertEquals(settingsPage.getAppSettingsTitle(), expectedSettingsTitle);
    }

    @Test
    @DisplayName("DAF-T3, Check that description of the allow tracking is displayed in any cases")
    public void SettingsTrackingTest() {

        var navigationBar = new NavigationBar();
        var settingsPage = navigationBar.clickSettingsButton();

        Assertions.assertTrue(settingsPage.existsTrackingDescription());
        Assertions.assertTrue(settingsPage.allowTrackingIsChecked());
    }

    @Test
    @DisplayName("DAF-, Check if notifications settings button is displayed on the settings page")
    public void SettingsNotificationsTest() {

        var navigationBar = new NavigationBar();
        var settingsPage = navigationBar.clickSettingsButton();
        Assertions.assertTrue(settingsPage.existsNotificationSettings());
        var notificationSettings = settingsPage.clickNotificationSettingsButton(2);
        Assertions.assertTrue(notificationSettings.notificationSettingsTitleIsDisplayed());
        navigateBackMultipleTimes(1);
    }
}
