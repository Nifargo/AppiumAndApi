package common.pageFinder;

import common.appiumElementsSettings.AppiumInit;

public class Finder {
    public void WebPageFinder(){
        Iterable<String> windowHandles = AppiumInit.getAppiumDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            System.out.println("Window handle: " + windowHandle);
            AppiumInit.getAppiumDriver().switchTo().window(windowHandle);
            String pageSource = (AppiumInit.getAppiumDriver().getPageSource());
            if (pageSource.startsWith("<html lang=\"en\"")){
                break;
            }
        }
    }
}
