package com.example.demoblaze.pageObjects;

import com.example.demoblaze.config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    private static final WebDriver webDriver = Browser.getWebDriver();

    @FindBy(xpath = "(//tbody[@id='tbodyid']/tr)")
    public WebElement cartProductsArray;
    @FindBy(xpath = "//button[@class='btn btn-success' and contains(text(),'Place Order')]")
    public WebElement placeOrderBtn;
    @FindBy(xpath = "(//div[@role='document']/div[@class=\"modal-content\"])[3]")
    public WebElement orderDetailsModal;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement orderDetails_name;
    @FindBy(xpath = "//input[@id='country']")
    public WebElement orderDetails_country;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement orderDetails_city;
    @FindBy(xpath = "//input[@id='card']")
    public WebElement orderDetails_creditCard;
    @FindBy(xpath = "//input[@id='month']")
    public WebElement orderDetails_month;
    @FindBy(xpath = "//input[@id='year']")
    public WebElement orderDetails_year;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    public WebElement orderDetails_confirmPurchase;
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']")
    public WebElement orderConfirmationModal;
    @FindBy(xpath = "//h3[@id='totalp']")
    public WebElement cartTotal;

    public static List<WebElement> cartItems() {
        return webDriver.findElements(By.xpath("(//tbody[@id='tbodyid']/tr)"));
    }

    public static List<WebElement> productPricesArray() {
        return webDriver.findElements(By.xpath("(//tbody[@id='tbodyid']/tr)/td[3]"));
    }

    public static List<WebElement> deleteItemsArray() {
        return webDriver.findElements(By.xpath("(//tbody[@id='tbodyid']/tr)/td[4]/a"));
    }

    public void init() {
        PageFactory.initElements(Browser.getWebDriver(), this);
    }


}
