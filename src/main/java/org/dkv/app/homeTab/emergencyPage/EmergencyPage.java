package org.dkv.app.homeTab.emergencyPage;

import common.appiumElementsSettings.AppiumSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.appiumElementsSettings.AppiumActions.getByLocatorForCurrentPlatform;
import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static io.appium.java_client.AppiumBy.ByAccessibilityId;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class EmergencyPage {

    AppiumSelector emergencyNumberTitle = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Emergency numbers']"), xpath("//XCUIElementTypeStaticText[@name='Emergency numbers']"));
    AppiumSelector emergencyCallButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/itemSectionClickableArea"), new ByAccessibilityId("Service hotline"));
    AppiumSelector dropDownPerCountry = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/emergencyExpandImage"), new ByAccessibilityId("Emergency numbers per country"));
    AppiumSelector andorraNumber = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Andorra']"), new ByAccessibilityId("Andorra"));
    AppiumSelector dialCallButton = new AppiumSelector(id("com.google.android.dialer:id/dialpad_voice_call_button"), new ByAccessibilityId("Austria"));

    public void clickCallButtonByIndex(int index) {
        By byLocator = getByLocatorForCurrentPlatform(emergencyCallButton);
        if (byLocator == null) {
            return;
        }
        List<WebElement> elements = getAppiumDriver().findElements(byLocator);
        if (index >= 0 && index < elements.size()) {
            elements.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    public String getEmergencyTitleText() {
        return findByBy(emergencyNumberTitle).getText();
    }

    public boolean visibilityEmergencyNumbersTitle() {
        return findByBy(emergencyNumberTitle).isDisplayed();
    }

    public boolean visibilityCallButton() {
        return findByBy(dialCallButton).isDisplayed();
    }

    public void clickDropDownPerCountryButton() {
        findByBy(dropDownPerCountry).click();
    }

    public void clickAndorraNumberButton() {
        findByBy(andorraNumber).click();
    }
}
