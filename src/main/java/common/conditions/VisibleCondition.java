package common.conditions;

import common.appiumElementsSettings.ElementActions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;

public class VisibleCondition implements Condition {

    private final WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(10));

    @Override
    public void check(ElementActions elementActions) {
        Assertions.assertTrue(elementActions.getElement().isDisplayed());
    }
}
