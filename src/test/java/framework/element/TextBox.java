package framework.element;

import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import org.openqa.selenium.By;

public class TextBox extends BaseElement {

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        LoggerLog.logInfo("Send text in " + name + ". Text: " + text);
        BrowserUtil.getDriver().findElement(locator).sendKeys(text);
    }
}
