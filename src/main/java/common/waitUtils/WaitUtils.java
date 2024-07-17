package common.waitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.appiumElementsSettings.AppiumInit.getAppiumDriver;

public class WaitUtils {

    public static WebElement waitFor(By locator) {
            if (locator == null) {
                throw new IllegalArgumentException("Locator must not be null");
            }

            WebDriverWait customWait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(15));
            return customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
}
