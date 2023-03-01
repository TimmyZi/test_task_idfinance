package tests.demoqatest;

import demoqa.object.BookStorePage;
import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import org.junit.Test;
import org.testng.Assert;

public class LogInFormTest extends BaseTest {

    @Test
    public void logInFormTest() {
        LoggerLog.logInfo("Test step 1");
        BrowserUtil.openUrl(DEMOQA_URL);
        BookStorePage bookStorePage = new BookStorePage();
        Assert.assertTrue(bookStorePage.isPageOpen(), "BookStorePage is not open or is not opened correctly");
        LoggerLog.logInfo("Test step 2");
        BrowserUtil.scrollDown();
        bookStorePage.getLeftSideMenuForm().clickLoginButton();
    }
}
