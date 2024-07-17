package common.gameChanger;

import common.appiumElementsSettings.AppiumInit;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class WebChange implements ContextChanger {

    @Override
    public void change() {
        Set<String> availableContexts;
        try {
            availableContexts = ((AndroidDriver) AppiumInit.getAppiumDriver()).getContextHandles();
            System.out.println("Found contexts size: '" + availableContexts.size() + "'");
            for (String context : availableContexts) {
                System.out.println("Found context: '" + context + "'");
                if (context != null && context.contains("WEBVIEW_com")) {
                    System.out.println("Switching context to: '" + context + "'");
                    ((AndroidDriver) AppiumInit.getAppiumDriver()).context(context);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}