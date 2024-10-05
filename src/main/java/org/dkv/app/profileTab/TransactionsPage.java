package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import org.dkv.app.profileTab.authorisations.LoginPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class TransactionsPage {

    AppiumSelector transactionsLoginButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/loginButton"), xpath("//XCUIElementTypeButton[@name='Log in']"));
    AppiumSelector transactionsTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/transactionsLoginToolbar"), xpath("//XCUIElementTypeStaticText[@name='Transactions']"));
    AppiumSelector transactionsTitleLoggedIn = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/transactionsToolbar"), xpath("//XCUIElementTypeStaticText[@name='Transactions']"));


    public boolean isEmptyTransactionsPage() {
        try {
            return findByBy(transactionsLoginButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public LoginPage clickLoginButton() {
        findByBy(transactionsLoginButton).click();
        return new LoginPage();
    }

    public boolean visibilityTransactionsTitle() {
        return findByBy(transactionsTitle).isDisplayed();
    }

    public boolean visibilityTransactionsTitleLoggedIn() {
        return findByBy(transactionsTitleLoggedIn).isDisplayed();
    }
}
