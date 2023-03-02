package framework.browser;

import framework.logger.LoggerLog;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static framework.config.ConfigManager.SETTINGS;

public class BrowserFactory {

    public static WebDriver createDriver() {

        WebDriver driver;

        switch (SETTINGS.get("browser").getAsString()) {
            case "safari" -> {
                LoggerLog.logInfo("Create safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                LoggerLog.logInfo("Create firefox driver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> {
                LoggerLog.logInfo("Create chrome driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}
