package helpers.baseHelpers;

import common.appiumElementsSettings.AppiumInit;
import common.systemLogger.AppLogger;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.dkv.app.firstOpenJourney.OnboardingPage;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;

import java.util.Objects;

import static helpers.baseHelpers.HelpersMethod.pause;

public class SkipOnBoardingTest {

    private static final Logger LOGGER = AppLogger.getLogger(SkipOnBoardingTest.class);

    public static void ensureAppIsActive() {
        AndroidDriver driver = (AndroidDriver) AppiumInit.getAppiumDriver();
        Activity activity = new Activity("com.dkveuroservice.mobileappkit", "com.dkveuroservice.mobileappkit.MainActivity");

        try {
            if (!Objects.equals(driver.currentActivity(), activity.getAppActivity())) {
                driver.launchApp();
            }
        } catch (Exception e) {
            System.err.println("Error while launching the app: " + e.getMessage());
        }
    }

    public static void completeOnboardingIfNeeded() {
        try {
            if (new OnboardingPage().existsSkipButton()) {
                var vehiclePage = new OnboardingPage().clickSkipButton();
                var locationPopUp = vehiclePage.clickLaterButton();
                var analysisPopUp = locationPopUp.clickAllowAllTimeButton();
                var rateMePopUp = analysisPopUp.clickActivateButton();
                rateMePopUp.clickThanksCloseButton();
            } else {
                new NavigationBar().clickProfileButton();
            }
        } catch (NoSuchElementException e) {
            LOGGER.error("Onboarding is not displayed: {}", e.getMessage());
        } catch (TimeoutException e) {
        LOGGER.error("Timeout while waiting for onboarding elements: {}", e.getMessage());
    }
    }

    @BeforeEach
    public void preSetup() {

        ensureAppIsActive();
        pause(5000);

        completeOnboardingIfNeeded();
        System.out.println("SkipOnBoardingTest @BeforeEach");
    }
}
