package org.dkv.app.feedbackMenuForm;

import org.dkv.app.header.AdditionalHeaders;

import static common.appiumElementsSettings.AppiumActions.find;
import static common.appiumElementsSettings.AppiumActions.findByDataId;
import static common.locatorsSettings.AppWebConfiguration.getLocatorByType;
import static common.locatorsSettings.WebTypeElements.A;
import static common.locatorsSettings.WebTypeElements.BUTTON;
import static common.locatorsSettings.WebTypeElements.INPUT;
import static common.locatorsSettings.WebTypeElements.SPAN;
import static common.locatorsSettings.WebTypeElements.TEXTAREA;


public class FeedbackProfilePage {
    String feedbackTittle = "//android.widget.TextView[@text = 'Feedback']";
    String feedbackWebTitle = getLocatorByType(SPAN, "title");
    String feedbackTextField = getLocatorByType(TEXTAREA, "feedbackTextarea");
    String submitButton = getLocatorByType(BUTTON, "sendFeedbackButton");
    String feedbackDescription = getLocatorByType(SPAN, "description");
    String cantLoginMsg = getLocatorByType(SPAN, "faqs-question-0");
    String dontHaveCredentialsMsg = getLocatorByType(SPAN, "faqs-question-1");
    String noCardInApp = getLocatorByType(SPAN, "faqs-question-2");
    String anyTransactionsMsg = getLocatorByType(SPAN, "faqs-question-3");
    String faqLinkUrl = getLocatorByType(A, "faqs-link-url");
    String emailField = getLocatorByType(INPUT, "form-email");
    String errorMessages = getLocatorByType(SPAN, "form-email-error");

    public void typeInTextField(String text) {
        find(feedbackTextField).clear();
        find(feedbackTextField).sendKeys(text);
    }

    public SuccessFeedback clickSubmitButton() {
        find(submitButton).click();
        return new SuccessFeedback();
    }

    public String getFeedbackTittle() {
        return find(feedbackTittle).getText();
    }

    public String getFeedbackWebTitle() {
        return findByDataId(feedbackWebTitle).getText();
    }

    public String getFeedbackDescription() {
        return findByDataId(feedbackDescription).getText();
    }

    public boolean cantLoginMsgVisible() {
        return find(cantLoginMsg).isDisplayed();
    }

    public void clickCantLoginDrop(){
        find(cantLoginMsg).click();
    }

    public boolean dontHaveCredentialsMsgVisible() {
        return find(dontHaveCredentialsMsg).isDisplayed();
    }

    public boolean noCardInAppMsgVisible() {
        return find(noCardInApp).isDisplayed();
    }

    public boolean anyTransactionsMsgVisible() {
        return find(anyTransactionsMsg).isDisplayed();
    }

    public AdditionalHeaders clickFAQLink() {
        find(faqLinkUrl).click();
        return new AdditionalHeaders();
    }

    public void clickEmailField(String text) {
        find(emailField).click();
        find(emailField).clear();
        find(emailField).sendKeys(text);
    }

    public boolean errorMessagesVisible() {
        return find(errorMessages).isDisplayed();
    }
}
