package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.pageFinder.Finder;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.HelpersMethod.scrollDown;

@Tag("ui")
public class ProfilePageTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T8 Check that nothing is displayed on the My favourites page for guest")
    public void MyFavouritesPageGuestTest() {

        var profilePage = new NavigationBar().clickProfileButton();
        var myFavouritesPage = profilePage.clickFavouriteButton();
        Assertions.assertTrue(myFavouritesPage.isEmptyFavouritesPage());
        navigateBackMultipleTimes(1);
        Assertions.assertTrue(new NavigationBar().isProfileButtonIsSelected());
    }

    @Test
    @DisplayName("DAF-T76 Check that nothing is displayed on My DKV cards page")
    public void MyDkvCardsPageGuest() {

        var profilePage = new NavigationBar().clickProfileButton();
        var myDkvCardsPage = profilePage.clickMyDkvCardsButton();
        Assertions.assertTrue(myDkvCardsPage.emptyMyDkvCardsPage());
        navigateBackMultipleTimes(1);
        Assertions.assertTrue(new NavigationBar().isProfileButtonIsSelected());
    }

    @Test
    @DisplayName("DAF-T10 Check that nothing is displayed on the transactions page")
    public void TransactionsPageGuest() {

        var profilePage = new NavigationBar().clickProfileButton();
        var transactionsPage = profilePage.clickTransactionsButton();
        Assertions.assertTrue(transactionsPage.isEmptyTransactionsPage());
        navigateBackMultipleTimes(1);
        Assertions.assertTrue(new NavigationBar().isProfileButtonIsSelected());
    }

    @Test
    @DisplayName("DAF-T14 Check feedback form after clicking it from profile page and email field validation")
    public void ProfileAppFeedbackFlowAndEmailField() {
        String expectedFeedbackTitle = "Feedback";
        List<String> emails = Arrays.asList("@example.com", "user@", "user@.com.my", "user@example.com (Joe Smith", "user@example..com");


        var profilePage = new NavigationBar().clickProfileButton();
        pause(100);
        scrollDown(0.8, 0.1, 0.5, 2000);
        var feedbackProfilePage = profilePage.clickFeedbackButton();
        Assertions.assertEquals(feedbackProfilePage.getFeedbackTittle(), expectedFeedbackTitle);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        Assertions.assertTrue(feedbackProfilePage.cantLoginMsgVisible());
        Assertions.assertTrue(feedbackProfilePage.dontHaveCredentialsMsgVisible());
        Assertions.assertTrue(feedbackProfilePage.noCardInAppMsgVisible());
        Assertions.assertTrue(feedbackProfilePage.anyTransactionsMsgVisible());

        for (String email : emails) {
            feedbackProfilePage.clickEmailField(email);
            feedbackProfilePage.typeInTextField("test");
            Assertions.assertTrue(feedbackProfilePage.errorMessagesVisible());
        }
        feedbackProfilePage.clickEmailField("dkv@gmail.com");

        feedbackProfilePage.clickSubmitButton();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);
        Assertions.assertTrue(new NavigationBar().isProfileButtonIsSelected());
    }

    @Test
    @Disabled
    @DisplayName("Check feedback form after clicking it from profile page and FAQ page")
    public void ProfileAppFeedbackFlowAndFAQPage() {

        var profilePage = new NavigationBar().clickProfileButton();
        pause(100);
        scrollDown(0.8, 0.1, 0.5, 2000);
        var feedbackProfilePage = profilePage.clickFeedbackButton();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        feedbackProfilePage.clickFAQLink();
//        TODO finish this test case when bug with title for Android is ready - https://dkv.atlassian.net/browse/DAF-2886

        handler.changeContext(ContextType.NATIVE);

    }

    @Test
    @DisplayName("DAF-T12 Check feedback page and forgot pass link")
    public void ProfileAppFeedbackPageAndForgotPass() {

        var profilePage = new NavigationBar().clickProfileButton();
        pause(100);
        scrollDown(0.8, 0.1, 0.5, 2000);
        var feedbackProfilePage = profilePage.clickFeedbackButton();

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        feedbackProfilePage.clickCantLoginDrop();

    }
}
