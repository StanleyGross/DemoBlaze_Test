package com.example.demoblaze.pageObjects;

import com.example.demoblaze.config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://www.demoblaze.com/
public class HomePage {
    private static final WebDriver webDriver = Browser.getWebDriver();

    @FindBy(xpath = "//*[contains(text(),'Sign up') and @id='signin2']")
    public WebElement signUpButton;
    @FindBy(xpath = "//li[@class='nav-item']/*[contains(text(),'Log in')]")
    public WebElement logInButton;
    @FindBy(xpath = "//*[@onclick='logOut()']")
    public WebElement logOutButton;
    @FindBy(xpath = "//li[@class='nav-item']/*[contains(text(),'Cart')]")
    public WebElement cartButton;
    @FindBy(xpath = "//*[@class='nav-link' and contains(text(),'Home ')]")
    public WebElement homeButton;
    @FindBy(xpath = "//button[@onclick='register()']")
    public WebElement signUpConfirm;
    @FindBy(xpath = "//button[@onclick='logIn()']")
    public WebElement logInConfirm;
    @FindBy(xpath = "//input[@id='sign-username']")
    public WebElement signUsernameInput;
    @FindBy(xpath = "//input[@id='sign-password']")
    public WebElement signPasswordInput;
    @FindBy(xpath = "//input[@id='loginusername']")
    public WebElement loginUsernameInput;
    @FindBy(xpath = "//input[@id='loginpassword']")
    public WebElement loginPasswordInput;
    @FindBy(xpath = "(//div[@role='document']/div[@class=\"modal-content\"])[2]")
    public WebElement signUpModal;
    @FindBy(xpath = "(//div[@role='document']/div[@class=\"modal-content\"])[2]")
    public WebElement loginModal;
    @FindBy(xpath = "(//li[@class='page-item'])[2]")
    public WebElement nextProductPage;

    public static List<WebElement> productItemsArray() {
        return webDriver.findElements(By.xpath("(//h4[@class='card-title'])"));
    }

    public void init() {
        PageFactory.initElements(Browser.getWebDriver(), this);
    }
}
