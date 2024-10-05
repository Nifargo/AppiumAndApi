package org.dkv.app.settingsTab;

import common.appiumElementsSettings.AppiumSelector;
import common.systemLogger.AppLogger;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.dkv.app.header.AdditionalHeaders;
import org.dkv.app.settingsTab.pricesCurrency.PricesCurrencyPage;
import org.slf4j.Logger;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static common.locatorsSettings.AppConfiguration.PACKAGE_FLAVOR;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class SettingsPage {
    private static final Logger logger = AppLogger.getLogger(SettingsPage.class);

    AppiumSelector pricesCurrencyButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/pricesAndCurrency"), new ByAccessibilityId("Prices & currency (fuelling)"));
    AppiumSelector notificationSettingsButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/notificationsSettings"), new ByAccessibilityId("Notification settings"));
    AppiumSelector allowTrackingButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/trackingSwitch"), id("ios"));
    AppiumSelector systemRadioButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/system"), xpath("//XCUIElementTypeStaticText[@name='System']"));
    AppiumSelector lightRadioButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/light"), xpath("//XCUIElementTypeStaticText[@name='Light']"));
    AppiumSelector darkRadioButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/dark"), xpath("//XCUIElementTypeStaticText[@name='Dark']"));
    AppiumSelector imprintMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/imprint"), new ByAccessibilityId("Imprint"));
    AppiumSelector dataProtectionMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/dataProtection"), new ByAccessibilityId("Data protection"));
    AppiumSelector faqsMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/faqs"), new ByAccessibilityId("FAQ"));
    AppiumSelector onboardingMenuButton = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/showOnboarding"), new ByAccessibilityId("Show DKV App explanation "));
    AppiumSelector appSettings = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/settingsTitle"), new ByAccessibilityId("App settings"));
    AppiumSelector descriptionTracking = new AppiumSelector(id(PACKAGE_FLAVOR + ":id/trackingDisclaimer"), id("ios"));

    public void clickOnboardingButton() {
        findByBy(onboardingMenuButton).click();
        new OnboardingPage();
    }

    public AdditionalHeaders clickImprintMenuButton() {
        findByBy(imprintMenuButton).click();
        return new AdditionalHeaders();
    }

    public AdditionalHeaders clickFaqsMenuButton() {
        findByBy(faqsMenuButton).click();
        return new AdditionalHeaders();
    }

    public boolean existsImprintButton() {
        return findByBy(imprintMenuButton).isDisplayed();
    }

    public boolean existsFaqButton() {
        return findByBy(faqsMenuButton).isDisplayed();
    }

    public PricesCurrencyPage clickPricesCurrencyButton() {
        findByBy(pricesCurrencyButton).click();
        return new PricesCurrencyPage();
    }

    public void clickSystemButton() {
        findByBy(systemRadioButton).click();
    }

    public boolean systemButtonIsChecked() {
        return findByBy(systemRadioButton).isChecked();
    }

    public void clickLightButton() {
        findByBy(lightRadioButton).click();
    }

    public boolean lightButtonIsChecked() {
        return findByBy(lightRadioButton).isChecked();
    }

    public void clickDarkButton() {
        findByBy(darkRadioButton).click();
    }

    public boolean darkButtonIsChecked() {
        return findByBy(darkRadioButton).isChecked();
    }

    public String getAppSettingsTitle() {
        return findByBy(appSettings).getText();
    }

    public boolean allowTrackingIsChecked() {
        return findByBy(allowTrackingButton).isChecked();
    }

    public boolean existsTrackingDescription() {
        return findByBy(descriptionTracking).isDisplayed();
    }

    public boolean existsNotificationSettings() {
        return findByBy(notificationSettingsButton).isDisplayed();
    }

    public AdditionalHeaders clickDataProtectMenuButton() {
        findByBy(dataProtectionMenuButton).click();
        return new AdditionalHeaders();
    }

    public NotificationSettings clickNotificationSettingsButton(int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                findByBy(notificationSettingsButton).click();
                if (new NotificationSettings().notificationSettingsTitleIsDisplayed()) {
                    return new NotificationSettings();
                }
            } catch (Exception e) {
                logger.error("Failed to click the Notification Settings button. Retrying..." + e.getMessage());
            }
            attempts++;
        }
        throw new RuntimeException("Failed to click the Notification Settings button after " + maxRetries + " attempts");
    }
}
