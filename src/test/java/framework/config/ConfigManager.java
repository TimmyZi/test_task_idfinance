package framework.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import framework.logger.LoggerLog;
import org.openqa.selenium.grid.config.ConfigException;

import java.io.FileReader;

public class ConfigManager {

    public static final JsonObject SETTINGS = loadData("src/test/resources/settings.json");
    public static final JsonObject ACCOUNT_DATA = loadData("src/test/resources/accountdata.json");

    private static JsonObject loadData(String fileNameOrPath) {
        try (FileReader reader = new FileReader(fileNameOrPath)) {
            LoggerLog.logInfo("Load data: " + fileNameOrPath);
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            LoggerLog.logError("Data parse error. File: " + fileNameOrPath);
            throw new ConfigException("Data parse error. File: " + fileNameOrPath);
        }
    }

}
