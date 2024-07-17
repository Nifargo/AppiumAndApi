package org.dkv.app.header;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class AdditionalHeaders {

    AppiumSelector imprintTitle = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Imprint']"), xpath(""));
    AppiumSelector faqTitle = new AppiumSelector(xpath("//android.widget.TextView[@text = 'FAQ']"), xpath(""));
    AppiumSelector dataProtection = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Data protection']"), xpath(""));


    public boolean getImprintTitleText() {
        return findByBy(imprintTitle).isDisplayed();
    }

    public boolean getFaqTitleText() {
        return findByBy(faqTitle).isDisplayed();
    }

    public boolean getDataProtectionTitleText() {
        return findByBy(dataProtection).isDisplayed();
    }
}
