package com.example.demoblaze.actions;

import com.example.demoblaze.config.Browser;
import com.example.demoblaze.pageObjects.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutActions {
    private static final WebDriver webdriver = Browser.getWebDriver();
    static Wait<WebDriver> wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
    static CartPage cartPage = new CartPage();

    public static void checkoutOrder(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        cartPage.init();
        wait.until(ExpectedConditions.visibilityOf(cartPage.placeOrderBtn));
        cartPage.placeOrderBtn.click();
        wait.until(ExpectedConditions.visibilityOf(cartPage.orderDetailsModal));
        cartPage.orderDetails_name.sendKeys(name);
        cartPage.orderDetails_country.sendKeys(country);
        cartPage.orderDetails_city.sendKeys(city);
        cartPage.orderDetails_creditCard.sendKeys(creditCard);
        cartPage.orderDetails_month.sendKeys(month);
        cartPage.orderDetails_year.sendKeys(year);
        cartPage.orderDetails_confirmPurchase.click();
        Thread.sleep(3000);
    }


}
