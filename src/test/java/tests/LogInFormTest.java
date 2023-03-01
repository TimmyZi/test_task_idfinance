package tests;

import demoqa.api.ApiUtil;
import demoqa.object.BookStorePage;
import demoqa.object.LoginPage;
import demoqa.object.ProfilePage;
import framework.alert.AlertUtil;
import framework.browser.BrowserUtil;
import framework.logger.LoggerLog;
import org.testng.Assert;
import org.testng.annotations.Test;

import static demoqa.data.DemoqaData.DEMOQA_ACCOUNT_DATA;

public class LogInFormTest extends BaseTest {

    String USER_NAME = DEMOQA_ACCOUNT_DATA.get("userName").getAsString();
    String PASSWORD = DEMOQA_ACCOUNT_DATA.get("password").getAsString();

    @Test
    public void logInFormTest() {
        LoggerLog.logInfo("LoginFormTest: step 1");
        ApiUtil.createAccount(USER_NAME, PASSWORD);
        BrowserUtil.openUrl(DEMOQA_URL);
        BookStorePage bookStorePage = new BookStorePage();
        Assert.assertTrue(bookStorePage.isPageOpen(), "BookStore page is not open or is not opened correctly");
        LoggerLog.logInfo("LoginFormTest: step 3");
        BrowserUtil.scrollDown();
        bookStorePage.getLeftSideMenuForm().clickLoginButton();
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isPageOpen(), "Login page is not open or is not opened correctly");
        LoggerLog.logInfo("LoginFormTest: step 4");
        BrowserUtil.scrollDown();
        loginPage.setUserName(USER_NAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        ProfilePage profilePage = new ProfilePage();
        Assert.assertTrue(profilePage.isPageOpen(), "Profile page is not open or is not opened correctly");
        Assert.assertEquals(USER_NAME, profilePage.getUserNameValue(), "User name is incorrect");
        LoggerLog.logInfo("LoginFormTest: step 5");
        BrowserUtil.scrollDown();
        profilePage.clickDeleteAccountButton();
        Assert.assertTrue(profilePage.getApproveWindowForm().isPageOpen(), "Approve window form is not open");
        profilePage.getApproveWindowForm().clickOkButton();
        Assert.assertTrue(AlertUtil.isAlertOpen(), "Account is not deleted");
        AlertUtil.accept();
        LoggerLog.logInfo("LoginFormTest: done");
    }
}
