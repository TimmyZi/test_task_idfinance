package demoqa.api;

import com.google.gson.JsonObject;
import framework.api.ApiManager;
import framework.logger.LoggerLog;
import lombok.SneakyThrows;

import static demoqa.data.DemoqaData.DEMOQA_DATA;


public class ApiUtil {

    private static final JsonObject API_REQUESTS = DEMOQA_DATA.get("apiRequestUrn").getAsJsonObject();
    private static final String API_URI = DEMOQA_DATA.get("api").getAsString();
    private static final String CREATE_ACCOUNT = API_REQUESTS.get("createAccount").getAsString();

    @SneakyThrows
    public static String createAccount(String userName, String password) {
        LoggerLog.logInfo("API: create account");
        JsonObject accountData = new JsonObject();
        accountData.addProperty("userName", userName);
        accountData.addProperty("password", password);
        String request = API_URI + CREATE_ACCOUNT;
        return ApiManager.post(request).body(accountData).asString().getBody();
    }

    @SneakyThrows
    public static String createAccount(JsonObject accountData) {
        LoggerLog.logInfo("API: create account");
        String request = API_URI + CREATE_ACCOUNT;
        return ApiManager.post(request).body(accountData).asString().getBody();
    }
}
