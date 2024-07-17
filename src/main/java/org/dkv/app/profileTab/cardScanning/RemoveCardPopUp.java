package org.dkv.app.profileTab.cardScanning;

import common.appiumElementsSettings.AppiumSelector;
import org.dkv.app.profileTab.ProfilePage;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class RemoveCardPopUp {

    AppiumSelector removeCardPopUpTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/alertTitle"), xpath("ios"));
    AppiumSelector removeCardButton = new AppiumSelector(id("android:id/button1"), xpath("ios"));
    AppiumSelector cancelButton = new AppiumSelector(id("android:id/button2"), xpath("ios"));

    public String getRemoveCardPopUpTitle() {
        return findByBy(removeCardPopUpTitle).getText();
    }

    public void clickRemoveCardButton() {
        findByBy(removeCardButton).click();
        new ProfilePage();
    }

    public void clickCancelButton() {
        findByBy(cancelButton).click();
        new ProfilePage();
    }
}
