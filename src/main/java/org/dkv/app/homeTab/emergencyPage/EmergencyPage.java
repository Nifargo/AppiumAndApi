package org.dkv.app.homeTab.emergencyPage;

import common.appiumElementsSettings.AppiumSelector;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static io.appium.java_client.AppiumBy.ByAccessibilityId;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class EmergencyPage {
    AppiumSelector emergencyNumberTitle = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Emergency numbers']"), xpath("//XCUIElementTypeStaticText[@name='Emergency numbers']"));
    AppiumSelector emergencyNumbersButton = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/emergencyExpandImage"), new ByAccessibilityId("chevron s down"));
    AppiumSelector serviceHotlineTitle = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/itemSectionPhoneNumber"), new ByAccessibilityId("Service hotline"));
    AppiumSelector internationalNumbers = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/internationalNumbers"), new ByAccessibilityId("International emergency number"));
    AppiumSelector eMobility = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/eMobility"), new ByAccessibilityId("Emergency number eMobility"));
    AppiumSelector numbersPerCountry = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/emergencyNumbersPerCountrySubtitle"), new ByAccessibilityId("Emergency numbers per country"));
    AppiumSelector andorraNumber = new AppiumSelector(id("com.dkveuroservice.mobileappkit:id/andoraNumber"), new ByAccessibilityId("Andorra"));

    public String getEmergencyTitleText() {
        return findByBy(emergencyNumberTitle).getText();
    }

    public void clickServiceHotline(){
        findByBy(serviceHotlineTitle).click();
    }

    public void clickEmergencyNumbers() {
        findByBy(emergencyNumbersButton).click();
    }

    public boolean visibilityEmergencyNumbersTitle() {
        return findByBy(emergencyNumberTitle).isDisplayed();
    }
}
