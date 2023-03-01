package tests;

import demoqa.data.DemoqaData;
import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static framework.config.ConfigManager.SETTINGS;

public abstract class BaseTest {

    protected final String DEMOQA_URL = DemoqaData.DEMOQA_DATA.get("url").getAsString();

    @BeforeMethod
    public void setup() {
        LoggerLog.logInfo("Setup");
        BrowserUtil.maximizeWindow();
        BrowserUtil.pageLoadTimeout(Integer.parseInt(SETTINGS.get("timeoutsDurationOfSeconds").getAsString()));
    }

    @AfterMethod
    public void tearDown() {
        LoggerLog.logInfo("teardown");
        BrowserUtil.quitDriver();
    }
}
