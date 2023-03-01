package tests.demoqatest;

import demoqa.data.DemoqaData;
import framework.browser.BrowserUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static framework.config.ConfigManager.SETTINGS;

public class BaseTest {

    protected static final String DEMOQA_URL = DemoqaData.DEMOQA_DATA.get("url").getAsString();

    @BeforeMethod
    public void setUpTest() {
        BrowserUtil.maximizeWindow();
        BrowserUtil.pageLoadTimeout(Integer.parseInt(SETTINGS.get("timeoutsDurationOfSeconds").getAsString()));
    }

    @AfterMethod
    public void tearDownTest() {
        BrowserUtil.quitDriver();
    }
}
