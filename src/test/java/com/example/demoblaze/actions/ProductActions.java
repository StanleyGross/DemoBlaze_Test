package com.example.demoblaze.actions;

import com.example.demoblaze.config.Browser;
import com.example.demoblaze.pageObjects.HomePage;
import com.example.demoblaze.pageObjects.ProductPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductActions {

    private static final WebDriver webdriver = Browser.getWebDriver();
    static Wait<WebDriver> wait = new WebDriverWait(webdriver, Duration.ofSeconds(5));
    static final ProductPage productPage = new ProductPage();
    static final HomePage homepage = new HomePage();

    public static void addProductToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(HomePage.productItemsArray().get(0)));
        HomePage.productItemsArray().get(0).click();
        productPage.init();
        wait.until(ExpectedConditions.visibilityOf(productPage.productName));
        wait.until(ExpectedConditions.visibilityOf(productPage.addToCartBtn));
        productPage.addToCartBtn.click();
        Thread.sleep(2000);
        webdriver.switchTo().alert().accept();
    }

    public static void multipleProductsToCart(@NotNull String page) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(HomePage.productItemsArray().get(0)));
        productPage.init();
        int index = 0;
        if (page.equalsIgnoreCase("first")) {
            while (index < 2) {
                Thread.sleep(2000);
                HomePage.productItemsArray().get(index).click();
                wait.until(ExpectedConditions.visibilityOf(productPage.productName));
                wait.until(ExpectedConditions.visibilityOf(productPage.addToCartBtn));
                productPage.addToCartBtn.click();
                Thread.sleep(2000);
                webdriver.switchTo().alert().accept();
                homepage.init();
                wait.until(ExpectedConditions.visibilityOf(homepage.homeButton));
                homepage.homeButton.click();
                index++;
            }
        }

        while (index < 2) {
            Thread.sleep(5000);
            HomePage.productItemsArray().get(index).click();
            wait.until(ExpectedConditions.visibilityOf(productPage.productName));
            wait.until(ExpectedConditions.visibilityOf(productPage.addToCartBtn));
            productPage.addToCartBtn.click();
            Thread.sleep(2000);
            webdriver.switchTo().alert().accept();
            homepage.init();
            wait.until(ExpectedConditions.visibilityOf(homepage.homeButton));
            homepage.homeButton.click();
            index++;
        }

    }
}
