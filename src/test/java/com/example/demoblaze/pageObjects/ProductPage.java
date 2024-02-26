package com.example.demoblaze.pageObjects;

import com.example.demoblaze.config.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(xpath = "//h2[@class='name']")
    public WebElement productName;

    @FindBy(xpath = "//*[@class='price-container']")
    public WebElement priceContainer;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    public WebElement addToCartBtn;

    public void init() {
        PageFactory.initElements(Browser.getWebDriver(), this);
        System.out.println(Browser.getWebDriver().getCurrentUrl());
    }

}
