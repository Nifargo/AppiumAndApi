package org.dkvProject.ui.guestFlow.anOnboardingPageProject;

import org.dkv.app.firstOpenJourney.DoYouLikePopUp;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
public class OnboardingFlowTest {

    @Test
    @DisplayName("DAF-T88 Check all buttons on the second page of the onboarding flow")
    public void CheckAllButtonsOnboardingFlow() throws InterruptedException {
        String expectedNextButton = "Next";
        String expectedSkipButton = "Skip";
        String expectedLoginButton = "Log in";
        String expectedContinueButton = "Continue without Login";

        var onboardingPage = new OnboardingPage();

        String nextButtonName = onboardingPage.getNextButtonText();
        String skipButtonName = onboardingPage.getOnBoardingBottomButtonText();
        Assertions.assertEquals(nextButtonName, expectedNextButton);
        Assertions.assertEquals(skipButtonName, expectedSkipButton);
        onboardingPage.clickNextButtonMultipleTimes(4);
        String loginButtonName = onboardingPage.getLoginButtonText();
        String continueButtonName = onboardingPage.getContinueButtonText();
        Assertions.assertEquals(loginButtonName, expectedLoginButton);
        Assertions.assertEquals(continueButtonName, expectedContinueButton);
        var onboardingLinearLayout = onboardingPage.clickContinueButton();
        Assertions.assertTrue(onboardingLinearLayout.isExistRefuellingButton());
        Assertions.assertTrue(onboardingLinearLayout.isExistCarButton());
        Assertions.assertTrue(onboardingLinearLayout.isExistChargeButton());
        Assertions.assertTrue(onboardingLinearLayout.isExistTruckButton());
        Assertions.assertTrue(onboardingLinearLayout.isExistTruckSmallButton());
        var locationPopUp = onboardingLinearLayout.clickNextButton();
        var analysisPopUp = locationPopUp.clickAllowAllTimeButton();
        analysisPopUp.clickActivateButton();
        var homePage = new DoYouLikePopUp().clickThanksCloseButton();
        Assertions.assertTrue(homePage.visibilityWelcomeTitle());
    }
}
