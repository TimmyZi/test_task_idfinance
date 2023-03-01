package framework.jsutil;

import framework.logger.LoggerLog;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSUtil {

    private static final String SCROLL_DOWN_SCRIPT = "window.scrollTo(0, document.body.scrollHeight)";

    public static JavascriptExecutor getJavascriptExecutor(WebDriver driver) {
        return ((JavascriptExecutor) driver);
    }

    public static void scrollDown(WebDriver driver) {
        LoggerLog.logInfo("Scroll down");
        JSUtil.getJavascriptExecutor(driver).executeScript(SCROLL_DOWN_SCRIPT);
    }
}
