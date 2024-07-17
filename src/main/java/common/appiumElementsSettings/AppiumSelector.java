package common.appiumElementsSettings;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class AppiumSelector {
    private By byAndroid;
    private By byIOS;

    public AppiumSelector(By byAndroid, By byIOS) {
        this.byAndroid = byAndroid;
        this.byIOS = byIOS;
    }
}
