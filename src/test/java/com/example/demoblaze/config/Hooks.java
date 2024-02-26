package com.example.demoblaze.config;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private static final WebDriver webdriver = Browser.getWebDriver();

    @After
    public void teardownAndScreenshotOnFailure(@NotNull Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] file = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate actualDate = LocalDate.now();
            String adt = actualDate.format(formatter);
            String scn = scenario.getName();
            scenario.attach(file, "image/png", "Scenario: " + scn + " - " + "Date: " + adt);
        }
    }
    @AfterAll
    public static void tearDown() {
        webdriver.quit();
    }
}