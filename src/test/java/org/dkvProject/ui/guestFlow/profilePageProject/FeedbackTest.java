package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextChanger;
import common.gameChanger.ContextSwitcher;
import common.gameChanger.ContextType;
import common.gameChanger.GameFactory;
import common.pageFinder.Finder;
import org.dkv.app.firstOpenJourney.DoYouLikePopUp;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
public class FeedbackTest {

    @Test
    @DisplayName("DAF-T89 Check feedback form after clicking it from profile page")
    public void AProfileAppFeedbackFlow() {

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

        GameFactory gameFactory = new ContextSwitcher().changeContextFrom(ContextType.WEB);
        ContextChanger freshContext = gameFactory.ContextChangerFactory();
        freshContext.change();

        new Finder().WebPageFinder();

        Assertions.assertEquals(feedbackProfilePage.getFeedbackWebTitle(), expectedFeedbackWebTitle);
        Assertions.assertEquals(feedbackProfilePage.getFeedbackDescription(), expectedDescription);
        feedbackProfilePage.typeInTextField("Good App and i like it");
        var successFeedback = feedbackProfilePage.clickSubmitButton();
        Assertions.assertEquals(successFeedback.getSuccessFinalText(), expectedFeedbackFinalMsg);

        var homePage = successFeedback.clickCloseButton();

        gameFactory = new ContextSwitcher().changeContextFrom(ContextType.NATIVE);
        freshContext = gameFactory.ContextChangerFactory();
        freshContext.change();

        Assertions.assertEquals(homePage.getWelcomeTitleText(), expectedWelcomeHomeTitle);

//        TODO add test case with positive feedback
    }
}
