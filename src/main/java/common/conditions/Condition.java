package common.conditions;

import common.appiumElementsSettings.ElementActions;

public interface Condition {

    Condition visible = new VisibleCondition();

    static Condition text(String expectedText) {
        return new TextCondition(expectedText);
    }

    void check(ElementActions elementActions);
}

