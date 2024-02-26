package com.example.demoblaze.config;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Hashtable;
import java.util.Map;

public class Browser {
    /**
     * In this class are the arch tools for the whole project, in this class u can find the Server to be used in the project, Directory for the downloads that occur on the tests executed.
     * The architecture used to open instances of the browser and other functions is on "Singleton" for better performance.
     * When Executing Tests, there's only one browser available.
     */

    //Static Final Section
    private static WebDriver webDriver;

    public Browser() {
    }

    @Before
    public void prepareWebDriver() {
        getWebDriver();
    }

    @NotNull
    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = getChromeOptions();
            webDriver = new ChromeDriver(options);
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
        return webDriver;
    }

    @NotNull
    private static ChromeOptions getChromeOptions() {
        Map<String, Object> preferences = new Hashtable<>();
//        preferences.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        // Hide and work without GUI
        // options.addArguments("--disable-gpu");
        // options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", preferences);
        return options;
    }
}
