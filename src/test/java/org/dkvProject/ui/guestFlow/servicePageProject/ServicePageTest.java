package org.dkvProject.ui.guestFlow.servicePageProject;

import common.listener.TestListener;
import helpers.baseHelpers.SkipOnBoardingTest;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
@Tag("ui")
public class ServicePageTest extends SkipOnBoardingTest {

    @Test
    @DisplayName("DAF-T74, Check if login button is displayed on the Service page for guest")
    public void ServiceLoginButton() {
        var servicePage = new NavigationBar().clickServiceButton();
        Assertions.assertTrue(servicePage.loginButtonVisible());
    }
}
