package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.pageFinder.Finder;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.homeTab.HomePage;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.HelpersMethod.scrollDown;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.password;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.userName;

@Tag("ui")
public class AuthorisationFlowTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T6 Check authorisation flow")
    public void LoginFlow() {

        String expectedLoggedInText = "You are logged in as";
        String expectedGuestUserTitle = "You are currently not logged in.";

        var profilePage = new NavigationBar().clickProfileButton();
        var loginPage = profilePage.clickLoginButton();

        pause(6000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.CHROME);
        new Finder().WebPageFinder();

        loginPage.typeLogin(userName());
        loginPage.typePassword(password());
        loginPage.clickLoginButton();

        handler.changeContext(ContextType.NATIVE);

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

        pause(6000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.CHROME);
        new Finder().WebPageFinder();

        loginPage.typeLogin(userName());
        loginPage.typePassword(password());
        loginPage.clickLoginButton();

        handler.changeContext(ContextType.NATIVE);

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

        var loginPage = transactionsPage.clickLoginButton();

        pause(6000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.CHROME);
        new Finder().WebPageFinder();

        loginPage.typeLogin(userName());
        loginPage.typePassword(password());
        loginPage.clickLoginButton();

        handler.changeContext(ContextType.NATIVE);

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
        var loginPage = myDkvCardsPage.clickCardsLoginButton();

        pause(6000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.CHROME);
        new Finder().WebPageFinder();

        loginPage.typeLogin(userName());
        loginPage.typePassword(password());
        loginPage.clickLoginButton();

        handler.changeContext(ContextType.NATIVE);
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

        pause(6000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.CHROME);
        new Finder().WebPageFinder();

        loginPage.typeLogin(userName());
        loginPage.typePassword(password());
        loginPage.clickLoginButton();

        handler.changeContext(ContextType.NATIVE);
        navigateBackMultipleTimes(1);
        var servicePage = navigationBar.clickServiceButton();

        Assertions.assertFalse(servicePage.loginButtonVisible());

        var profilePage = navigationBar.clickProfileButton();
        var logOutPOpUp = profilePage.clickLogOutButton();
        logOutPOpUp.clickLogOutNow();
        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }
}
