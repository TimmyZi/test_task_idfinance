package framework.wait;

import framework.browser.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static framework.config.ConfigManager.SETTINGS;

public class WaitUtil {

    public void elementToBeClickable(By locator) {
        getWaiter().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void visibilityOfElementLocated(By locator) {
        getWaiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void until(Function<? super WebDriver, Object> condition) {
        getWaiter().until(condition);
    }

    private WebDriverWait getWaiter() {
        return new WebDriverWait(BrowserUtil.getDriver()
                , Duration.ofSeconds(Integer.parseInt(SETTINGS.get("timeoutsDurationOfSeconds").getAsString())));
    }
}
