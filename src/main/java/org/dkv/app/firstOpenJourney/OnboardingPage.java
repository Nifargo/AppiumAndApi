package org.dkv.app.firstOpenJourney;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class OnboardingPage {

    AppiumSelector onBoardingBottomButton = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"onBoardingBottomButton\")"), xpath("/XCUIElementTypeButton[@name='Skip']"));
    AppiumSelector onBoardingTopButton = new AppiumSelector(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"onBoardingTopButton\")"), xpath("//XCUIElementTypeButton[@name='Next']"));

    public OnboardingLinearLayout clickSkipButton() {
            findByBy(onBoardingBottomButton).click();
        return new OnboardingLinearLayout();
    }

    public void clickNextButtonMultipleTimes(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            findByBy(onBoardingTopButton).click();
            Thread.sleep(1000);
        }
    }

    public String getNextButtonText() {
        return findByBy(onBoardingTopButton).getText();
    }

    public String getOnBoardingBottomButtonText() {
        return findByBy(onBoardingBottomButton).getText();
    }

    public String getContinueButtonText() {
        return findByBy(onBoardingBottomButton).getText();
    }

    public OnboardingLinearLayout clickContinueButton() {
        findByBy(onBoardingBottomButton).click();
        return new OnboardingLinearLayout();
    }

    public String getLoginButtonText() {
        return findByBy(onBoardingTopButton).getText();
    }

    public boolean existsSkipButton() {
        return findByBy(onBoardingBottomButton).isDisplayed();
    }
}
