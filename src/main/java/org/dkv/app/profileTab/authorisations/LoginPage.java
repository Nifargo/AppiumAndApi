package org.dkv.app.profileTab.authorisations;

import org.dkv.app.profileTab.ProfilePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.find;

public class LoginPage {
    String loginField = "//input[@id='username']";
    String passwordField = "//input[@id='password']";
    String SignInButton = "//*[@id='kc-login']";

    public boolean existLoginButton() {
        try {
            return find(loginField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void typeLogin(String text) {
        find(loginField).click();
        find(loginField).sendKeys(text);
    }

    public void typePassword(String text) {
        find(passwordField).click();
        find(passwordField).sendKeys(text);
    }

    public void clickLoginButton() {
        find(SignInButton).click();
        new ProfilePage();
    }

}
