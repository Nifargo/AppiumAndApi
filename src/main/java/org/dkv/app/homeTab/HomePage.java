package org.dkv.app.homeTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.homeTab.emergencyPage.EmergencyPage;
import org.dkv.app.profileTab.MyDkvCardsPage;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class HomePage {
    AppiumSelector emergencyNumbersButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/callTv"), xpath("//XCUIElementTypeButton[@name=' Emergency numbers']"));
    AppiumSelector appBannerList = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/bannerList"), new ByAccessibilityId("Banner list"));

    AppiumSelector inMyAreaSectionTittle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/nearbyTitleTv"), new ByAccessibilityId("In my area"));
    AppiumSelector inMyAreaUpdateButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/btnUpdate"), xpath("//XCUIElementTypeStaticText[@name='Update']"));
    AppiumSelector myDkvCardsMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/myDkvCardBtn"), new ByAccessibilityId("My DKV cards"));
    AppiumSelector welcomeTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/welcomeTitle"), new ByAccessibilityId("Welcome back"));
    AppiumSelector dkvNewsPageTitle = new AppiumSelector(xpath("//android.widget.TextView[@text = 'DKV News']"), xpath("//XCUIElementTypeStaticText[@name='DKV News']"));
    AppiumSelector emergencyNumbersMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/emergencyNumbersBtn"), new ByAccessibilityId("Emergency numbers"));
    AppiumSelector dkvNewsMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/newsBtn"), new ByAccessibilityId("DKV News"));
    AppiumSelector notificationPermission = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/notificationPermission"), new ByAccessibilityId("Notification permission"));
    AppiumSelector showOnMapSectionTittle = new AppiumSelector(xpath(PACKAGE_FLAVOR + ":id/filtersTitle"), new ByAccessibilityId("Show on the map"));
    AppiumSelector notificationBannerTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/notificationBannerTitle"), new ByAccessibilityId("Notifications"));
    AppiumSelector notificationBannerCloseBtn = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/notificationBannerClose"), new ByAccessibilityId("Close"));
    AppiumSelector enableNotificationBtn = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/enableNotificationsButton"), new ByAccessibilityId("Enable notifications"));
    AppiumSelector disableNotificationsBtn = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/disableNotificationsButton"), new ByAccessibilityId("Disable notifications"));

    public String getNotificationBannerTitleText() {
        return findByBy(notificationBannerTitle).getText();
    }

    public boolean visibilityNotificationBannerCloseBtn() {
        return findByBy(notificationBannerCloseBtn).isDisplayed();
    }

    public boolean visibilityEnableNotificationBtn() {
        return findByBy(enableNotificationBtn).isDisplayed();
    }

    public boolean visibilityDisableNotificationsBtn() {
        return findByBy(disableNotificationsBtn).isDisplayed();
    }

    public String getWelcomeTitleText() {
        return findByBy(welcomeTitle).getText();
    }

    public boolean visibilityWelcomeTitle() {
        return findByBy(welcomeTitle).isDisplayed();
    }

    public EmergencyPage clickEmergencyButton() {
        findByBy(emergencyNumbersButton).click();
        return new EmergencyPage();
    }

    public MyDkvCardsPage clickMyDkvCardsButton() {
        findByBy(myDkvCardsMenuButton).click();
        return new MyDkvCardsPage();
    }

    public void clickDkvNewsButton() {
        findByBy(dkvNewsMenuButton).click();
    }

    public EmergencyPage clickEmergencyNumbersMenuButton() {
        findByBy(emergencyNumbersMenuButton).click();
        return new EmergencyPage();
    }

    public String getDkvNewsTitleText() {
        return findByBy(dkvNewsPageTitle).getText();
    }

    public boolean visibilityInMyAreaSection() {
        return findByBy(inMyAreaSectionTittle).isDisplayed();
    }

    public boolean visibilityInMyAreaUpdateButton() {
        return findByBy(inMyAreaUpdateButton).isDisplayed();
    }

    public boolean visibilityShowOnMapSection() {
        return findByBy(showOnMapSectionTittle).isDisplayed();
    }

    public boolean visibilityAppBanner(){
        return findByBy(appBannerList).isDisplayed();
    }

    public boolean visibilityNotificationPermission(){
        return findByBy(notificationPermission).isDisplayed();
    }
}
