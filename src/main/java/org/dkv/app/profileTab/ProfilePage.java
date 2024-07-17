package org.dkv.app.profileTab;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.feedbackMenuForm.FeedbackProfilePage;
import org.dkv.app.profileTab.authorisations.LoginPage;
import org.dkv.app.profileTab.authorisations.logOutPopUp.LogOutPopUp;
import org.dkv.app.profileTab.cardScanning.AllowScanningPopUp;
import org.dkv.app.profileTab.cardScanning.RemoveCardPopUp;
import org.dkv.app.profileTab.myVehicle.MyVehiclePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    AppiumSelector loginButton = new AppiumSelector(xpath("//android.widget.TextView[@text ='Log in']"), xpath("//XCUIElementTypeButton[@name='Login']"));
    AppiumSelector loggedInUserText = new AppiumSelector(xpath("//android.widget.TextView[@text ='You are logged in as']"), xpath("ios"));
    AppiumSelector logOutButton = new AppiumSelector(xpath("//android.widget.TextView[@text ='Logout']"), xpath("ios"));
    AppiumSelector guestUserTitle = new AppiumSelector(xpath("//android.widget.TextView[@text ='You are currently not logged in.']"), new ByAccessibilityId("You are currently not logged in."));
    AppiumSelector scanCardButton = new AppiumSelector(xpath("//android.widget.TextView[@text ='Scan card']"), xpath("//XCUIElementTypeButton[@name='Scan card']"));
    AppiumSelector removeCardButton = new AppiumSelector(xpath("//android.widget.TextView[@text ='Remove from app']"), xpath("ios"));
    AppiumSelector favouritesButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/myFavouritesBtn"), new ByAccessibilityId("Favourites"));
    AppiumSelector myDkvCardsButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/myCards"), new ByAccessibilityId("My DKV Cards"));
    AppiumSelector transactionsButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/myTransactionsBtn"), new ByAccessibilityId("Transactions"));
    AppiumSelector myVehicleButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/my_vehicle"), new ByAccessibilityId("My vehicle"));
    AppiumSelector feedbackButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/feedbackButton"), xpath("//XCUIElementTypeStaticText[@name='We would like to hear your feedback!']"));

    public String getLoggedInUserText() {
        return findByBy(loggedInUserText).getText();
    }

    public LoginPage clickLoginButton() {
        findByBy(loginButton).click();
        return new LoginPage();
    }

    public MyFavouritesPage clickFavouriteButton() {
        findByBy(favouritesButton).click();
        return new MyFavouritesPage();
    }

    public MyDkvCardsPage clickMyDkvCardsButton() {
        findByBy(myDkvCardsButton).click();
        return new MyDkvCardsPage();
    }

    public TransactionsPage clickTransactionsButton() {
        findByBy(transactionsButton).click();
        return new TransactionsPage();
    }

    public MyVehiclePage clickMyVehicleButton() {
        findByBy(myVehicleButton).click();
        return new MyVehiclePage();
    }

    public FeedbackProfilePage clickFeedbackButton() {
        findByBy(feedbackButton).click();
        return new FeedbackProfilePage();
    }

    public LogOutPopUp clickLogOutButton() {
        findByBy(logOutButton).click();
        return new LogOutPopUp();
    }

    public boolean existLogOutButton() {
        return findByBy(logOutButton).isDisplayed();
    }

    public String getGuestUserTitleText() {
        return findByBy(guestUserTitle).getText();
    }

    public AllowScanningPopUp clickScanCardButton() {
        findByBy(scanCardButton).click();
        return new AllowScanningPopUp();
    }

    public RemoveCardPopUp clickRemoveCardButton() {
        findByBy(removeCardButton).click();
        return new RemoveCardPopUp();
    }

    public boolean existsScanCardButton() {
        try {
            return findByBy(scanCardButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean existLoginButton() {
        return findByBy(loginButton).isDisplayed();
    }
}
