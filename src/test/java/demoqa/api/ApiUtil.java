package demoqa.api;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.Unirest;
import framework.api.ApiManager;
import framework.logger.LoggerLog;
import lombok.SneakyThrows;

import static demoqa.data.DemoqaData.DEMOQA_DATA;


public class ApiUtil {

    private static final JsonObject API_REQUESTS = DEMOQA_DATA.get("apiRequestUrn").getAsJsonObject();
    private static final String API_URI = DEMOQA_DATA.get("api").getAsString();
    private static final String CREATE_ACCOUNT = API_REQUESTS.get("createAccount").getAsString();
    private static final String GET_BOOK_INFO = API_REQUESTS.get("getBookInfo").getAsString();

    @SneakyThrows
    public static void createAccount(String userName, String password) {
        LoggerLog.logInfo("API: create account");
        String request = API_URI + CREATE_ACCOUNT;
        String response = ApiManager.post(request)
                .field("userName", userName)
                .field("password", password).asString().getBody();
        LoggerLog.logInfo("API: Response - " + response);
    }

    @SneakyThrows
    public static String getBooksInfo() {
        LoggerLog.logInfo("API: get book info");
        String request = API_URI + GET_BOOK_INFO;
        return Unirest.get(request).asString().getBody();
    }
}
