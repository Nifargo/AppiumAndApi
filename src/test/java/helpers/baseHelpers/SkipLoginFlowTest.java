package helpers.baseHelpers;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.systemLogger.AppLogger;
import org.dkv.app.navigationLine.NavigationBar;
import org.dkv.app.profileTab.authorisations.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;

import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.SkipOnBoardingTest.completeOnboardingIfNeeded;
import static helpers.baseHelpers.SkipOnBoardingTest.ensureAppIsActive;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.password;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.userName;

public class SkipLoginFlowTest {
    private static final Logger logger = AppLogger.getLogger(SkipLoginFlowTest.class);

    @AfterAll
    public static void postSetup() {
        ensureAppIsActive();
        pause(5000);

        completeLogoutFlow();
        System.out.println("Logout flow @AfterEach");
    }

    public static void performLogin(LoginPage loginPage) {
        ContextHandler handler = new ContextHandler();
        try {
            handler.changeContext(ContextType.CHROME);
        } catch (NoSuchContextException e) {
            handler.changeContext(ContextType.NATIVE);
            return;
        }
        if (loginPage.existLoginButton()) {
            loginPage.typeLogin(userName());
            loginPage.typePassword(password());
            loginPage.clickLoginButton();
            handler.changeContext(ContextType.NATIVE);
        }
        handler.changeContext(ContextType.NATIVE);
    }

    private static void completeLogoutFlow() {
        var profilePage = new NavigationBar().clickProfileButton();
        try {
            if (profilePage.existLogOutButton()) {
                var logOutPopUp = profilePage.clickLogOutButton();
                logOutPopUp.clickLogOutNow();
            }
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Logout flow failed: {}", e.getMessage());
        }
    }

    @BeforeEach
    public void preSetup() {

        ensureAppIsActive();
        pause(5000);

        completeOnboardingIfNeeded();
        completeLoginFlowIfNeeded();
        System.out.println("SkipOnBoardingTest and login flow @BeforeEach");
    }

    public void completeLoginFlowIfNeeded() {
        var profilePage = new NavigationBar().clickProfileButton();
        try {
            if (profilePage.existLoginButton()) {
                var loginPage = profilePage.clickLoginButton();
                pause(6000);
                if (profilePage.existLogOutButton()) {
                    new NavigationBar().clickProfileButton();
                } else {
                    performLogin(loginPage);
                }
            }
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Login flow failed: {}", e.getMessage());
        }
    }
}
