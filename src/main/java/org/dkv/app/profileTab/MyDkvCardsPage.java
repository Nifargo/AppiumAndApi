package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;
import org.dkv.app.profileTab.authorisations.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class MyDkvCardsPage {

    AppiumSelector cardsLoginButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/walletLoginButton"), new AppiumBy.ByAccessibilityId("//XCUIElementTypeButton[@name='Log in']"));
    AppiumSelector cardsTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/walletLoginToolbar"), new AppiumBy.ByAccessibilityId("//XCUIElementTypeStaticText[@name='My DKV cards']"));
    AppiumSelector cardsTitleLoginUser = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/toolbar"), new AppiumBy.ByAccessibilityId("//XCUIElementTypeStaticText[@name='My DKV cards']"));


    public boolean emptyMyDkvCardsPage() {
        return findByBy(cardsLoginButton).isDisplayed();
    }

    public LoginPage clickCardsLoginButton() {
        findByBy(cardsLoginButton).click();
        return new LoginPage();
    }

    public boolean visibilityLoginButton() {
        try {
            return findByBy(cardsLoginButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean visibilityCardsTitleGuest() {
        return findByBy(cardsTitle).isDisplayed();
    }

    public boolean visibilityCardsTitleLogin() {
        return findByBy(cardsTitleLoginUser).isDisplayed();
    }
}
