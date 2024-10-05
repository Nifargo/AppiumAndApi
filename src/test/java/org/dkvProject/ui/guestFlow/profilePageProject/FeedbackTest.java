package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.listener.TestListener;
import common.pageFinder.Finder;
import org.dkv.app.firstOpenJourney.DoYouLikePopUp;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.HelpersMethod.resetApp;

@ExtendWith(TestListener.class)
@Tag("ui")
public class FeedbackTest {

    @Test
    @DisplayName("DAF-T89 Check feedback form after clicking it from profile page")
    public void AProfileAppFeedbackFlow() {

        resetApp();

        String expectedFeedbackTitle = "Feedback";
        String expectedFeedbackWebTitle = "What are your experiences with the DKV app?";
        String expectedDescription = "You have noticed incorrect station information? Please report them directly on the respective station page.";
        String expectedFeedbackFinalMsg = "Thank you for sharing your feedback!";
        String expectedWelcomeHomeTitle = "Welcome back";

        var onboardingPage = new OnboardingPage();
        var onboardingLinearLayout = onboardingPage.clickSkipButton();
        var locationPopUp = onboardingLinearLayout.clickLaterButton();
        var analysisPopUp = locationPopUp.clickAllowAllTimeButton();
        analysisPopUp.clickActivateButton();
        var feedbackProfilePage = new DoYouLikePopUp().clickNoButton();

        Assertions.assertEquals(feedbackProfilePage.getFeedbackTittle(), expectedFeedbackTitle);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        Assertions.assertEquals(feedbackProfilePage.getFeedbackWebTitle(), expectedFeedbackWebTitle);
        Assertions.assertEquals(feedbackProfilePage.getFeedbackDescription(), expectedDescription);
        feedbackProfilePage.typeInTextField("Good App and i like it");
        var successFeedback = feedbackProfilePage.clickSubmitButton();

        Assertions.assertEquals(successFeedback.getSuccessFinalText(), expectedFeedbackFinalMsg);

        var homePage = successFeedback.clickCloseButton();

        handler.changeContext(ContextType.NATIVE);

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);

//        TODO add test case with positive feedback
    }
}
