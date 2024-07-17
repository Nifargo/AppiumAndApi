package common.conditions;

import common.appiumElementsSettings.ElementActions;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;

@AllArgsConstructor
public class TextCondition implements Condition {
    private final String expectedText;
    private final WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(10));


    @Override
    public void check(ElementActions elementActions) {
        wait.until(ExpectedConditions.textToBePresentInElement(elementActions.getElement(), expectedText));
        String actualText = elementActions.getText();

        Assertions.assertEquals(expectedText, actualText, "Text does not match the expected value.");

    }
}
