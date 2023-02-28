package framework.config;

import com.google.gson.JsonObject;
import framework.logger.LoggerLog;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.grid.config.ConfigException;

import java.io.FileReader;

public class ConfigManager {

    private static JsonObject settings;
    private static JsonObject accountData;
    private static final JSONParser parser = new JSONParser();

    public static void loadSettings() {
        settings = loadData("src/test/resources/settings.json");
    }

    public static void loadAccountData() {
        accountData = loadData("src/test/resources/accountdata.json");
    }

    public static String getSettings(String key) {
        return settings.get(key).getAsString();
    }

    public static String getAccountData(String key) {
        return accountData.get(key).getAsString();
    }

    private static JsonObject loadData(String fileNameOrPath) {
        try (FileReader reader = new FileReader(fileNameOrPath)) {
            LoggerLog.logInfo("Load data: " + fileNameOrPath);
            return (JsonObject) parser.parse(reader);
        } catch (Exception e) {
            LoggerLog.logError("Data parse error. File: " + fileNameOrPath);
            throw new ConfigException("Data parse error. File: " + fileNameOrPath);
        }
    }
}
