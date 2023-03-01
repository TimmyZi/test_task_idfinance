package framework.helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.logger.LoggerLog;

import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    public static JsonObject parseToJsonObject(String string) {
        LoggerLog.logInfo("Parse to JsonObject");
        return JsonParser.parseString(string).getAsJsonObject();
    }

    public static List<String> getListDataByJsonArray(JsonArray jsonArray, String key) {
        LoggerLog.logInfo("Get list data by JsonArray");
        List<String> dataByJsonArray = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            dataByJsonArray.add(jsonObject.get(key).getAsString());
        }
        return dataByJsonArray;
    }
}
