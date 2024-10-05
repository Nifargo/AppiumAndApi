package org.dkvProject.ui.guestFlow.profilePageProject;

import common.listener.TestListener;
import helpers.baseHelpers.SkipLoginFlowTest;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.homeTab.HomePage;
import org.dkv.app.navigationLine.NavigationBar;
import org.dkv.app.profileTab.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.scrollDown;
import static helpers.baseHelpers.SkipLoginFlowTest.performLogin;

@ExtendWith(TestListener.class)
@Tag("ui")
public class AuthorisationFlowTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T6 Check authorisation flow")
    public void LoginFlow() {

        String expectedLoggedInText = "You are logged in as";
        String expectedGuestUserTitle = "You are currently not logged in.";

        var profilePage = new ProfilePage();
        new SkipLoginFlowTest().completeLoginFlowIfNeeded();

        Assertions.assertEquals(profilePage.getLoggedInUserText(), expectedLoggedInText);

        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickCancelButton();

        Assertions.assertEquals(profilePage.getLoggedInUserText(), expectedLoggedInText);

        profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();

        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }

    @Test
    @DisplayName("DAF-T82 Check login flow from Service page")
    public void ServiceLoginFlowGuest() {

        String expectedGuestUserTitle = "You are currently not logged in.";

        var navigationBar = new NavigationBar();

        var servicePage = navigationBar.clickServiceButton();
        var loginPage = servicePage.clickLoginButton();

        performLogin(loginPage);

        navigationBar.clickProfileButton();

        navigationBar.clickServiceButton();
        Assertions.assertFalse(servicePage.loginButtonVisible());

        var profilePage = navigationBar.clickProfileButton();

        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();

        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }

    @Test
    @DisplayName("DAF-T80 Check login flow from My Transactions page")
    public void TransactionsLoginFlowGuest() {

        String expectedGuestUserTitle = "You are currently not logged in.";

        var navigationBar = new NavigationBar();
        var profilePage = navigationBar.clickProfileButton();
        var transactionsPage = profilePage.clickTransactionsButton();

        Assertions.assertTrue(transactionsPage.visibilityTransactionsTitle());

        var loginPage = transactionsPage.clickLoginButton();

        performLogin(loginPage);
        navigateBackMultipleTimes(1);
        navigationBar.clickProfileButton();
        profilePage.clickTransactionsButton();

        Assertions.assertFalse(transactionsPage.isEmptyTransactionsPage());
        navigateBackMultipleTimes(1);
        var servicePage = navigationBar.clickServiceButton();

        Assertions.assertFalse(servicePage.loginButtonVisible());

        navigationBar.clickProfileButton();
        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();

        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }

    @Test
    @DisplayName("DAF-T79 Check Login flow from My DKV cards page")
    public void MyDkvCardsLoginFlow() {

        String expectedGuestUserTitle = "You are currently not logged in.";

        var navigationBar = new NavigationBar();
        var profilePage = navigationBar.clickProfileButton();
        var myDkvCardsPage = profilePage.clickMyDkvCardsButton();

        Assertions.assertTrue(myDkvCardsPage.visibilityCardsTitleGuest());

        var loginPage = myDkvCardsPage.clickCardsLoginButton();

        performLogin(loginPage);
        navigateBackMultipleTimes(1);

        navigationBar.clickProfileButton();
        profilePage.clickMyDkvCardsButton();

        Assertions.assertFalse(myDkvCardsPage.visibilityLoginButton());

        navigateBackMultipleTimes(1);
        var servicePage = navigationBar.clickServiceButton();

        Assertions.assertFalse(servicePage.loginButtonVisible());

        navigationBar.clickProfileButton();
        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();

        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }

    @Test
    @DisplayName("DAF-T81 Check login flow from My Dkv Cards page on Home page")
    public void HomeMyDkvCardsLoginFlow() {

        String expectedGuestUserTitle = "You are currently not logged in.";

        var homePage = new HomePage();
        var navigationBar = new NavigationBar();
        scrollDown(0.8, 0.1, 0.5, 2000);
        var dkvCardsPage = homePage.clickMyDkvCardsButton();

        var loginPage = dkvCardsPage.clickCardsLoginButton();

        performLogin(loginPage);

        navigateBackMultipleTimes(1);
        var servicePage = navigationBar.clickServiceButton();

        Assertions.assertFalse(servicePage.loginButtonVisible());

        var profilePage = navigationBar.clickProfileButton();
        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();
        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }
}
