package framework.elements;

import framework.browser.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.config.ConfigManager.SETTINGS;

public class Wait {

    public void elementToBeClickable(By locator) {
        getWaiter().until(ExpectedConditions.elementToBeClickable(locator));
    }

    private static WebDriverWait getWaiter() {
        return new WebDriverWait(BrowserUtil.getDriver()
                , Duration.ofSeconds(Integer.parseInt(SETTINGS.get("timeoutsDurationOfSeconds").getAsString())));
    }
}
