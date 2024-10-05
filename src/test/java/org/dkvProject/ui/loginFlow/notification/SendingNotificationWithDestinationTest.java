package org.dkvProject.ui.loginFlow.notification;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.listener.TestListener;
import common.pageFinder.Finder;
import helpers.baseHelpers.HelpersMethod;
import helpers.baseHelpers.SkipLoginFlowTest;
import org.dkv.app.NotificationCenter;
import org.dkv.app.firstOpenJourney.DoYouLikePopUp;
import org.dkv.app.homeTab.HomePage;
import org.dkv.app.mapTab.MapPage;
import org.dkv.app.mapTab.StationDetailsPage;
import org.dkv.app.navigationLine.NavigationBar;
import org.dkv.app.profileTab.MyDkvCardsPage;
import org.dkv.app.profileTab.TransactionsPage;
import org.dkv.app.settingsTab.NotificationSettings;
import org.dkvProject.api.notificationFlow.SendingNotificationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.DirectionForWebScrolling.DOWN;
import static helpers.baseHelpers.HelpersMethod.navigateBackMultipleTimes;
import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.HelpersMethod.scrollUsingJS;

public class SendingNotificationWithDestinationTest extends SkipLoginFlowTest {

    @ExtendWith(TestListener.class)
    @Test
    @DisplayName("Send notification with destination Home page")
    public void testSendingNotificationHomePage() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingUserIdHomePage();
        new HelpersMethod().openNotificationsCenter();
        new NotificationCenter().openNotification();

        new DoYouLikePopUp().clickThanksCloseButton();

        Assertions.assertTrue(new HomePage().visibilityWelcomeTitle());
    }

    @Test
    @DisplayName("Send notification with destination Map page")
    public void testSendingNotificationMapPage() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingUserIdMapPage();
        new HelpersMethod().openNotificationsCenter();
        new NotificationCenter().openNotification();

        Assertions.assertTrue(new MapPage().searchFieldIsDisplayed());
    }

    @Test
    @DisplayName("Send notification with destination Transactions page")
    public void testSendingNotificationTransactionsPage() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingUserIdTransactionsPage();
        new HelpersMethod().openNotificationsCenter();
        new NotificationCenter().openNotification();

        Assertions.assertTrue(new TransactionsPage().visibilityTransactionsTitleLoggedIn());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Send notification with destination My DKV cards page page")
    public void testSendingNotificationMyDkvCardPage() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);


        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingUserIdMyCardsPage();
        new HelpersMethod().openNotificationsCenter();
        pause(3000);
        new NotificationCenter().openNotification();

        Assertions.assertTrue(new MyDkvCardsPage().visibilityCardsTitleLogin());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Send notification with topics and destinations My DKV cards page")
    public void testSendingNotificationDestinationTopics() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingTopics();
        new HelpersMethod().openNotificationsCenter();
        new NotificationCenter().openNotification();

        Assertions.assertTrue(new MyDkvCardsPage().visibilityCardsTitleLogin());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Send notification with un selected topics and destinations My DKV cards page")
    public void testSendingNotificationWithoutTopics() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettingsPage = new NotificationSettings();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.WEB);

        notificationSettingsPage.clickAppNewsCheckBox();
        scrollUsingJS(DOWN);
        notificationSettingsPage.clickSaveButton();

        handler.changeContext(ContextType.NATIVE);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingTopics();
        new HelpersMethod().openNotificationsCenter();

        Assertions.assertFalse(new NotificationCenter().NotificationMsgNotDisplayed());
        navigateBackMultipleTimes(1);
    }

    @Test
    @DisplayName("Send notification with charging session number")
    public void testSendingNotificationWithChargingSessionNumber() {

        var settings = new NavigationBar().clickSettingsButton();
        var notificationSettings = settings.clickNotificationSettingsButton(2);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);

        notificationSettings.clickEnableNotification();

        handler.changeContext(ContextType.NATIVE);

        navigateBackMultipleTimes(1);

        pause(5000);
        SendingNotificationTests apiTests = new SendingNotificationTests();
        apiTests.testSendingUserIdChargingSession();
        new HelpersMethod().openNotificationsCenter();
        new NotificationCenter().openNotification();

        Assertions.assertTrue(new StationDetailsPage().visibilityChargingSessionTitle());
        navigateBackMultipleTimes(1);
    }
}
