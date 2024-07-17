package helpers.baseHelpers;

import common.gameChanger.ContextHandler;
import common.gameChanger.ContextType;
import common.pageFinder.Finder;
import org.dkv.app.navigationLine.NavigationBar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;

import static helpers.baseHelpers.HelpersMethod.pause;
import static helpers.baseHelpers.SkipOnBoardingTest.completeOnboardingIfNeeded;
import static helpers.baseHelpers.SkipOnBoardingTest.ensureAppIsActive;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.password;
import static org.dkv.api.controller.credentials.CredentialsYmlReader.userName;

public class SkipLoginFlowTest {

    @BeforeEach
    public void preSetup() {

        ensureAppIsActive();
        pause(5000);

        completeOnboardingIfNeeded();
        completeLoginFlowIfNeeded();
        System.out.println("SkipOnBoardingTest and login flow @BeforeEach");
    }

    @AfterEach
    public void postSetup(){
        ensureAppIsActive();
        pause(5000);

        completeLogoutFlow();
        System.out.println("Logout flow @AfterEach");
    }

    private void completeLoginFlowIfNeeded(){
        var profilePage = new NavigationBar().clickProfileButton();
        try{
            if(profilePage.existLoginButton()){
                var loginPage = profilePage.clickLoginButton();
                pause(6000);
                ContextHandler handler = new ContextHandler();
                handler.changeContext(ContextType.CHROME);
                new Finder().WebPageFinder();

                loginPage.typeLogin(userName());
                loginPage.typePassword(password());
                loginPage.clickLoginButton();

                handler.changeContext(ContextType.NATIVE);
            }
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    private void completeLogoutFlow(){
        var profilePage = new NavigationBar().clickProfileButton();
        try{
            if(profilePage.existLogOutButton()){
                var logOutPopUp = profilePage.clickLogOutButton();
                logOutPopUp.clickLogOutNow();
            }
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

}
