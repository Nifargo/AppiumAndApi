package org.dkv.app.profileTab.authorisations.logOutPopUp;

import common.appiumElementsSettings.AppiumSelector;
import org.dkv.app.profileTab.ProfilePage;
import org.openqa.selenium.By;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.id;

public class LogOutPopUp {

    AppiumSelector LogOutTitle = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/title_template"), By.xpath("ios"));
    AppiumSelector LogOutNow = new AppiumSelector(id("android:id/button1"), By.xpath("ios"));
    AppiumSelector cancelButton = new AppiumSelector(id("android:id/button2"), By.xpath("ios"));

    public String getLogOutTitle() {
        return findByBy(LogOutTitle).getText();
    }

    public void clickLogOutNow() {
        findByBy(LogOutNow).click();
        new ProfilePage();
    }

    public void clickCancelButton() {
        findByBy(cancelButton).click();
    }
}
