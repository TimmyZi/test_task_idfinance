package framework.elements;

import framework.logger.LoggerLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Label extends BaseElement {
    public Label(By locator, String name) {
        super(locator, name);
    }

    public boolean isElementWithDataPresent(String data) {
        LoggerLog.logInfo("Search data on the page: " + data);
        List<WebElement> elements = getListWebElements();
        boolean isPresent = false;
        for (WebElement element : elements) {
            if (element.getText().equals(data)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }
}
