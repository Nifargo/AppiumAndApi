package common.appiumElementsSettings;

import common.conditions.Condition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@Getter
public class ElementActions {

    private WebElement element;

    public ElementActions shouldHas(Condition condition) {
        condition.check(this);
        return this;
    }

    public ElementActions shouldBe(Condition condition) {
        condition.check(this);
        return this;
    }

    public ElementActions click() {
        element.click();
        return this;
    }

    public ElementActions clear() {
        element.clear();
        return this;
    }

    public void sendKeys(String text) {
        element.sendKeys(text);
    }

    public String getText() {
        try {
            return this.element.getText();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            throw new AssertionError("Element is not displayed");
        }
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public boolean isChecked() {
        return element.getAttribute("checked").equals("true");
    }

    public boolean isNotClickable() {
        return element.getAttribute("clickable").equals("false");
    }

    public boolean isElementAbsent() {
        return !element.isDisplayed();
    }
}
