package framework.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;
import framework.logger.LoggerLog;

public class ApiManager {
    public static HttpRequestWithBody post(String request) {
        LoggerLog.logInfo("API: Sending POST request with body");
        return Unirest.post(request);
    }
}
