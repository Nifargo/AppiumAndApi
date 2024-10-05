package org.dkvProject.ui.guestFlow.profilePageProject;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.listener.TestListener;
import common.pageFinder.Finder;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static helpers.baseHelpers.HelpersMethod.scrollDown;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvCardId;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvCustomerId;
import static org.dkv.api.controller.cardValidation.DkvYmlReader.dkvExpiredDate;

@ExtendWith(TestListener.class)
@Tag("ui")
public class CardScanningTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T15 Add manually DKV card for guest user")
    public void AddManuallyCardForGuestUser() throws InterruptedException {

        String expectRemoveCardPOpUpTitle = "Do you really want to remove this card from the app?";
        String expectedGuestUserTitle = "You are currently not logged in.";

        var navigationBar = new NavigationBar();
        var profilePage = navigationBar.clickProfileButton();
        var allowScanningPopUp = profilePage.clickScanCardButton();

        var scanCardPage = allowScanningPopUp.clickAllowOneTimeButton();

        Assertions.assertTrue(scanCardPage.clickLightOnButton());
        Assertions.assertTrue(scanCardPage.isScanAreaDisplayed());

//        TODO add waiting for popup after developers decrease time for popup

        var addManuallyCard = scanCardPage.clickEnterManually();

        Thread.sleep(5000);

        ContextHandler handler = new ContextHandler();
        handler.changeContext(ContextType.WEB);
        new Finder().WebPageFinder();

        addManuallyCard.enterCardId(dkvCardId());
        addManuallyCard.enterCustomerNumber(dkvCustomerId());
        addManuallyCard.enterExpirationDate(dkvExpiredDate());
        scrollDown(0.8, 0.1, 0.5, 2000);
        addManuallyCard.clickConfirmButton();

        handler.changeContext(ContextType.NATIVE);

        var servicePage = navigationBar.clickServiceButton();
        Assertions.assertTrue(servicePage.loginButtonVisible());

        navigationBar.clickProfileButton();
        Assertions.assertTrue(profilePage.existLoginButton());
        Assertions.assertFalse(profilePage.existsScanCardButton());

        var removePopUp = profilePage.clickRemoveCardButton();
        Assertions.assertEquals(removePopUp.getRemoveCardPopUpTitle(), expectRemoveCardPOpUpTitle);

        removePopUp.clickCancelButton();
        removePopUp = profilePage.clickRemoveCardButton();
        removePopUp.clickRemoveCardButton();
        Assertions.assertEquals(profilePage.getGuestUserTitleText(), expectedGuestUserTitle);
    }
}
