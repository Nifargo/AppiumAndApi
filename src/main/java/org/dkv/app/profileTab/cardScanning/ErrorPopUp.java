package org.dkv.app.profileTab.cardScanning;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class ErrorPopUp {

    AppiumSelector enterAgainButton = new AppiumSelector(xpath("//android.widget.Button[@text = 'Enter again']"), xpath("ios"));
    AppiumSelector scanCardButton = new AppiumSelector(new ByAccessibilityId("Scan Card"), xpath("ios"));

    public CardManuallyPage clickEnterAgainButton() {
        findByBy(enterAgainButton).click();
        return new CardManuallyPage();
    }

    public CardScanPage clickScanCardButton() {
        findByBy(scanCardButton).click();
        return new CardScanPage();
    }
}
