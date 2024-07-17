package org.dkv.app.serviceTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;
import org.dkv.app.profileTab.authorisations.LoginPage;
import org.openqa.selenium.NoSuchElementException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class ServicePage {

    AppiumSelector loginButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Log in']"), new AppiumBy.ByAccessibilityId("Login"));

    public boolean loginButtonVisible() {
        try {
            return findByBy(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public LoginPage clickLoginButton() {
        findByBy(loginButton).click();
        return new LoginPage();
    }
}
