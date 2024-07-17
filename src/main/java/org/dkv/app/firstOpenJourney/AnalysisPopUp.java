package org.dkv.app.firstOpenJourney;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class AnalysisPopUp {

    AppiumSelector allowAnalysisPOpUp = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/alertTitle"), id("Allow analysis?"));
    AppiumSelector activateButton = new AppiumSelector(id("android:id/button1"), xpath("//XCUIElementTypeButton[@name='Activate']"));
    AppiumSelector deactivateButton = new AppiumSelector(id("android:id/button2"), xpath("//XCUIElementTypeButton[@name='Deactivate']"));

    public void getAnalysisPopUp() {
        findByBy(allowAnalysisPOpUp).getText();
    }

    public DoYouLikePopUp clickActivateButton() {
        findByBy(activateButton).click();
        return new DoYouLikePopUp();
    }

    public DoYouLikePopUp clickDeactivateButton() {
        findByBy(deactivateButton).click();
        return new DoYouLikePopUp();
    }
}
