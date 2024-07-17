package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;
import org.dkv.app.profileTab.authorisations.LoginPage;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class MyDkvCardsPage {

    AppiumSelector cardsLoginButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/walletLoginButton"), new AppiumBy.ByAccessibilityId("//XCUIElementTypeButton[@name='Log in']"));


    public boolean emptyMyDkvCardsPage() {
        return findByBy(cardsLoginButton).isDisplayed();
    }

    public LoginPage clickCardsLoginButton() {
        findByBy(cardsLoginButton).click();
        return new LoginPage();
    }
}
