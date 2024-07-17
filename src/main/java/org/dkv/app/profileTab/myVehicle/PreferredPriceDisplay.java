package org.dkv.app.profileTab.myVehicle;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class PreferredPriceDisplay {

    AppiumSelector loginButton = new AppiumSelector(xpath("//android.widget.TextView[@text ='Diesel']"), xpath("ios"));
    AppiumSelector loggedInUserText = new AppiumSelector(xpath("//android.widget.TextView[@text ='Petrol']"), xpath("ios"));

    public void clickDieselButton() {
        findByBy(loginButton).click();
    }

    public void clickPetrolButton() {
        findByBy(loggedInUserText).click();
    }
}
