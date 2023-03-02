package demoqa.data;

import com.google.gson.JsonObject;

import static framework.config.ConfigManager.*;

public class DemoqaData {
    public static final JsonObject DEMOQA_DATA = SETTINGS.get("application").getAsJsonObject().get("demoqaBookStore").getAsJsonObject();
    public static final JsonObject DEMOQA_ACCOUNT_DATA = ACCOUNT_DATA.get("demoqa").getAsJsonObject();
}
