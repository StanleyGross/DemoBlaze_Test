package com.example.demoblaze.actions;

import com.example.demoblaze.config.Browser;
import com.example.demoblaze.pageObjects.HomePage;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserActions {
    private static final WebDriver webdriver = Browser.getWebDriver();
    static Wait<WebDriver> wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
    static HomePage homePage = new HomePage();

    @SneakyThrows
    public static void loginAction(String username, String password) {
        homePage.init();
        homePage.logInButton.click();
        homePage.loginUsernameInput.sendKeys(username);
        homePage.loginPasswordInput.sendKeys(password);
        homePage.logInConfirm.click();
        Thread.sleep(3000);
    }

    public static void signUpAction(String username, String password) throws InterruptedException {
        homePage.init();
        homePage.signUpButton.click();
        homePage.signUsernameInput.sendKeys(username);
        homePage.signPasswordInput.sendKeys(password);
        homePage.signUpConfirm.click();
        Thread.sleep(3000);
        if(wait.until(ExpectedConditions.alertIsPresent())!= null){
            webdriver.switchTo().alert().accept();
        }
    }

}
