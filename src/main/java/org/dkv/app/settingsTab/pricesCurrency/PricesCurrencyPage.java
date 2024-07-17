package org.dkv.app.settingsTab.pricesCurrency;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.find;
import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;

public class PricesCurrencyPage {

    String pricesCurrencyTitle = "//android.widget.TextView[@text = 'Prices & currency (fuelling)']";
    AppiumSelector title = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/toolbarTitleId"), id("ios"));
    AppiumSelector pricesCurrencyButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/pricesAndCurrency"), id("ios"));


    public String getPricesCurrencyTitle() {
        return find(pricesCurrencyTitle).getText();
    }

    public String getTitle() {
        return findByBy(title).getText();
    }
}
