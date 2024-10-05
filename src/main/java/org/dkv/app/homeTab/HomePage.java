package org.dkv.app.homeTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.homeTab.emergencyPage.EmergencyPage;
import org.dkv.app.profileTab.MyDkvCardsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.appiumElementsSettings.AppiumActions.getByLocatorForCurrentPlatform;
import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static common.locatorsSettings.AppConfiguration.androidJetPackLocator;
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
    AppiumSelector showOnMapSectionTittle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/filtersTitle"), new ByAccessibilityId("Show on the map"));
    AppiumSelector notificationBannerTitle = new AppiumSelector(androidJetPackLocator("notificationBannerTitle"), new ByAccessibilityId("Notifications"));
    AppiumSelector notificationBannerXBtn = new AppiumSelector(androidJetPackLocator("notificationBannerClose"), new ByAccessibilityId("Close"));
    AppiumSelector enableNotificationBtn = new AppiumSelector(androidJetPackLocator("enableNotificationsButton"), new ByAccessibilityId("Enable notifications"));
    AppiumSelector disableNotificationsBtn = new AppiumSelector(androidJetPackLocator("disableNotificationsButton"), new ByAccessibilityId("Disable notifications"));
    AppiumSelector notificationBannerCloseButton = new AppiumSelector(androidJetPackLocator("closeNotificationsButton"), new ByAccessibilityId("Close"));
    AppiumSelector showOnTheMapFilterButton = new AppiumSelector(xpath("//android.widget.TextView[@resource-id='" + PACKAGE_FLAVOR + ":id/poiTypeIconTv']"), new ByAccessibilityId("Accessibility ID if available"));

    public String getNotificationBannerTitleText() {
        return findByBy(notificationBannerTitle).getText();
    }

    public void clickCloseMsgButton() {
        findByBy(notificationBannerCloseButton).click();
    }

    public void clickDisableNotificationsBtn() {
        findByBy(disableNotificationsBtn).click();
    }

    public PermissionPopUp clickEnableNotificationBtn() {
        findByBy(enableNotificationBtn).click();
        return new PermissionPopUp();
    }

    public void clickCloseNotificationBanner() {
        findByBy(notificationBannerXBtn).click();
    }

    public String getFilterTextByIndex(int index) {
        By byLocator = getByLocatorForCurrentPlatform(showOnTheMapFilterButton);
        if (byLocator == null) {
            return "Unsupported driver type";
        }
        List<WebElement> elements = getAppiumDriver().findElements(byLocator);
        if (index >= 0 && index < elements.size()) {
            return elements.get(index).getText();
        } else {
            return "Index out of bounds";
        }
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

    public boolean visibilityAppBanner() {
        return findByBy(appBannerList).isDisplayed();
    }

    public boolean visibilityNotificationBanner(){
            try {
                return findByBy(notificationPermission).isDisplayed();
            } catch (NoSuchElementException | TimeoutException e) {
                return false;
            }
        }
}
