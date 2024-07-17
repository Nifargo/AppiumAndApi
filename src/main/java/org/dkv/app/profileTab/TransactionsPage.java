package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import org.dkv.app.profileTab.authorisations.LoginPage;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class TransactionsPage {

    AppiumSelector transactionsLoginButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/loginButton"), xpath("//XCUIElementTypeButton[@name='Log in']"));

    public boolean isEmptyTransactionsPage() {
        return findByBy(transactionsLoginButton).isDisplayed();
    }

    public LoginPage clickLoginButton() {
        findByBy(transactionsLoginButton).click();
        return new LoginPage();
    }
}
