package org.dkv.app.firstOpenJourney;

import common.appiumElementsSettings.AppiumSelector;
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import org.dkv.app.feedbackMenuForm.FeedbackProfilePage;
import org.dkv.app.homeTab.HomePage;

import static common.appiumElementsSettings.AppiumActions.findByBy;
import static org.openqa.selenium.By.xpath;

public class DoYouLikePopUp {

    AppiumSelector thankYouPopUp = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Do you like the DKV Mobility App?']"), xpath(""));
    AppiumSelector yesButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'Yes, I like it']"), xpath(""));
    AppiumSelector noButton = new AppiumSelector(xpath("//android.widget.TextView[@text = 'No, I do not like it']"), xpath(""));
    AppiumSelector ratingCloseButton = new AppiumSelector(new ByAccessibilityId("Close"), xpath("ios"));

    public String getThankYouPopUpTitle() {
        return findByBy(thankYouPopUp).getText();
    }

    public void clickYesButton() {
        findByBy(yesButton).click();
    }

    public FeedbackProfilePage clickNoButton() {
        findByBy(noButton).click();
        return new FeedbackProfilePage();
    }

    public HomePage clickThanksCloseButton() {
        findByBy(ratingCloseButton).click();
        return new HomePage();
    }
}
