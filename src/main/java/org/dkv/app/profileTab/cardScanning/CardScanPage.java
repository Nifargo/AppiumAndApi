package org.dkv.app.profileTab.cardScanning;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CardScanPage {
    AppiumSelector lightOnButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/lightSwitch"), xpath("ios"));
    AppiumSelector scanArea = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/scanningProgress"), xpath("ios"));
    AppiumSelector enterManually = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/enterCardButton"), xpath("ios"));

    public boolean clickLightOnButton() {
        return findByBy(lightOnButton).isDisplayed();
    }

    public boolean isScanAreaDisplayed() {
        return findByBy(scanArea).isDisplayed();
    }

    public CardManuallyPage clickEnterManually() {
        findByBy(enterManually).click();
        return new CardManuallyPage();
    }
}
