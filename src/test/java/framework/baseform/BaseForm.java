package framework.baseform;

import framework.element.BaseElement;
import framework.logger.LoggerLog;

public abstract class BaseForm {
    protected BaseElement uniqueElement;
    protected String name;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpen() {
        LoggerLog.logInfo("Check " + name + " is open");
        uniqueElement.waitForVisibility();
        return uniqueElement.isPresent();
    }
}
