package framework.alert;

import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import framework.wait.WaitUtil;
import org.openqa.selenium.Alert;

public class AlertUtil {

    public static void accept() {
        LoggerLog.logInfo("click accept in the alert window");
        switchToAlert().accept();
    }

    public static boolean isAlertOpen() {
        LoggerLog.logInfo("Checking if the alert is open");
        try {
            WaitUtil wait = new WaitUtil();
            wait.until(d -> switchToAlert() != null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Alert switchToAlert() {
        LoggerLog.logInfo("Switch to alert");
        return BrowserUtil.getDriver().switchTo().alert();
    }
}
