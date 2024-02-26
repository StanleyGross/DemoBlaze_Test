package com.example.demoblaze.actions;

import com.example.demoblaze.config.Browser;
import com.example.demoblaze.pageObjects.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartActions {

    private static final WebDriver webdriver = Browser.getWebDriver();
    static Wait<WebDriver> wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
    private static final CartPage cartpage = new CartPage();

    public static boolean checkPricingTotal() throws InterruptedException {
        webdriver.navigate().refresh();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(CartPage.cartItems()));
        cartpage.init();
        int index = 0;
        int CartTotal = 0;
        int totalItems = CartPage.cartItems().size();
        while (index < totalItems) {
            int productPrice = Integer.parseInt(CartPage.productPricesArray().get(index).getText());
            CartTotal = CartTotal + productPrice;
            index++;
        }
        return Integer.parseInt(cartpage.cartTotal.getText()) == CartTotal;
    }

    public static void deleteItems(int amount) throws InterruptedException {
        int index = 0;
        while (index < amount) {
            wait.until(ExpectedConditions.elementToBeClickable(CartPage.deleteItemsArray().get(index)));
            CartPage.deleteItemsArray().get(index).click();
            Thread.sleep(2000);
            index++;
        }
    }

}
