package framework.browser;

import framework.jsutil.JSUtil;
import framework.logger.LoggerLog;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserUtil {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            LoggerLog.logInfo("Driver initialization");
            driver = BrowserFactory.createDriver();
        }
        return driver;
    }

    public static void openUrl(String url) {
        LoggerLog.logInfo("Open URL " + url);
        BrowserUtil.getDriver().get(url);
    }

    public static void maximizeWindow() {
        LoggerLog.logInfo("Set maximum window size");
        BrowserUtil.getDriver().manage().window().maximize();
    }

    public static void pageLoadTimeout(int seconds) {
        LoggerLog.logInfo("Set page load timeout in seconds: " + seconds);
        BrowserUtil.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    public static void scrollDown() {
        JSUtil.scrollDown(BrowserUtil.getDriver());
    }

    public static void quitDriver() {
        LoggerLog.logInfo("Close the WebDriver");
        BrowserUtil.getDriver().quit();
        driver = null;
    }
}
