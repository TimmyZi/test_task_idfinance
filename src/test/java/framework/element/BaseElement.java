package framework.element;

import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import framework.wait.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElement {

    protected final By locator;
    protected final String name;
    protected final WaitUtil wait = new WaitUtil();

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        LoggerLog.logInfo("Click " + name);
        BrowserUtil.getDriver().findElement(locator).click();
    }

    public String getText() {
        LoggerLog.logInfo("Get text by " + name);
        return BrowserUtil.getDriver().findElement(locator).getText();
    }

    public boolean isPresent() {
        LoggerLog.logInfo("Check " + name + " is present");
        List<WebElement> webElements = BrowserUtil.getDriver().findElements(locator);
        if (webElements.isEmpty()) {
            LoggerLog.logInfo(name + " not found");
            return false;
        }
        LoggerLog.logInfo(name + " is present");
        return true;
    }

    public void waitForClickable() {
        LoggerLog.logInfo("Waiting for " + name + " to be clickable");
        wait.elementToBeClickable(locator);
    }

    public void waitForVisibility() {
        LoggerLog.logInfo("Waiting for " + name + " to be visible");
        wait.visibilityOfElementLocated(locator);
    }

    protected List<WebElement> getListWebElements() {
        LoggerLog.logInfo("Get list WebElements by " + name);
        return BrowserUtil.getDriver().findElements(locator);
    }
}
