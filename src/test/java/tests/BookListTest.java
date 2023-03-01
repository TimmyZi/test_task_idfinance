package tests;

import com.google.gson.JsonObject;
import demoqa.api.ApiUtil;
import demoqa.object.BookStorePage;
import framework.browser.BrowserUtil;
import framework.helpers.JsonHelper;
import framework.logger.LoggerLog;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookListTest extends BaseTest {

    @Test
    public void bookListTest() {
        LoggerLog.logInfo("BookListTest: step 1");
        BrowserUtil.openUrl(DEMOQA_URL);
        BookStorePage bookStorePage = new BookStorePage();
        Assert.assertTrue(bookStorePage.isPageOpen(), "BookStore page is not open or is not opened correctly");
        LoggerLog.logInfo("BookListTest: step 2");
        JsonObject apiBookInfo = JsonHelper.parseToJsonObject(ApiUtil.getBooksInfo());
        List<String> apiBookTitles = JsonHelper.getListDataByJsonArray(apiBookInfo.get("books").getAsJsonArray(), "title");
        List<String> uiBookTitles = bookStorePage.getBooksWrapperForm().getBookTitlesList();
        Assert.assertEquals(uiBookTitles, apiBookTitles, "Book titles is not equal");
        LoggerLog.logInfo("BookListTest: done");
    }
}
