package com.example.demoblaze.steps;

import com.example.demoblaze.actions.CartActions;
import com.example.demoblaze.actions.CheckoutActions;
import com.example.demoblaze.actions.ProductActions;
import com.example.demoblaze.actions.UserActions;
import com.example.demoblaze.config.Browser;
import com.example.demoblaze.pageObjects.CartPage;
import com.example.demoblaze.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class demoBlazeSteps {
    private static final WebDriver webDriver = Browser.getWebDriver();
    static Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    static HomePage homePage = new HomePage();
    static CartPage cartPage = new CartPage();


    @Given("I Navigate to the homepage")
    public void iNavigateToTheHomepage() {
        webDriver.get("https://www.demoblaze.com/");
    }

    @Given("^I am in the Homepage$")
    public void i_am_in_the_homepage() {
        homePage.init();
        Assertions.assertTrue(homePage.homeButton.isDisplayed(), "Home Button is not displayed");
    }

    @And("I SignUp to DemoBlaze using the username {string} and password {string}")
    public void iSignUpToDemoBlazeUsingTheUsernameAndPassword(String username, String password) throws InterruptedException {
        UserActions.signUpAction(username, password);
    }

    @Then("I expect a successful signUp")
    public void iExpectASuccesfullSignUp() throws InterruptedException {
        homePage.init();
        Thread.sleep(5000);
        Assertions.assertTrue(homePage.homeButton.isDisplayed());
    }

    @Then("I expect that the SignUp Failed")
    public void iExpectThatTheSignUpFailed() {
        homePage.init();
        Assertions.assertTrue(homePage.signUpModal.isDisplayed());
    }

    @And("I expect that the Login failed")
    public void iExpectThatTheLoginFailed() {
        homePage.init();
        Assertions.assertNotNull(wait.until(ExpectedConditions.alertIsPresent()));
        webDriver.switchTo().alert().accept();
    }

    @Then("I login to DemoBlaze using the username {string} and password {string}")
    public void iLoginToDemoBlazeUsingTheUsernameAndPassword(String username, String password) {
        UserActions.loginAction(username, password);
    }

    @And("I Verify Im Logged In")
    public void iVerifyImLoggedIn() {
        homePage.init();
        wait.until(ExpectedConditions.visibilityOf(homePage.logOutButton));
        Assertions.assertTrue(homePage.logOutButton.isDisplayed());

    }

    @And("I Add a product to the Cart")
    public void iAddAProductToTheCart() throws InterruptedException {
        ProductActions.addProductToCart();
    }

    @Then("I Navigate to the Cart")
    public void iNavigateToTheCart() {
        webDriver.get("https://www.demoblaze.com/cart.html");
        cartPage.init();
        Assertions.assertTrue(cartPage.cartProductsArray.isDisplayed(), "Items are not in the cart");

    }

    @And("I complete order using the following information: {string}, {string}, {string}, {string}, {string} ,{string}")
    public void iCompleteOrderUsingTheFollowingInformation(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        CheckoutActions.checkoutOrder(name, country, city, creditCard, month, year);
    }

    @Then("I navigate to the next product page\\(pagination)")
    public void iNavigateToTheNextProductPagePagination() throws InterruptedException {
        homePage.init();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.nextProductPage));
        Thread.sleep(2000);
        homePage.nextProductPage.click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(HomePage.productItemsArray().get(1)));
    }

    @And("I Check Total price Against Added products")
    public void iCheckTotalPriceAgainstAddedProducts() throws InterruptedException {
        webDriver.navigate().refresh();
        Assertions.assertTrue(CartActions.checkPricingTotal());

    }

    @And("I delete {int} item\\(s) from cart")
    public void iDeleteItemSFromCart(int arg0) throws InterruptedException {
        CartActions.deleteItems(arg0);
    }

    @Then("I expect that the purchase is incorrect")
    public void iExpectThatThePurchaseIsIncorrect() {
        cartPage.init();
        webDriver.switchTo().alert().accept();
    }

    @And("I Expect the order to be correct")
    public void iExpectTheOrderToBeCorrect() {
        cartPage.init();
        wait.until(ExpectedConditions.visibilityOf(cartPage.orderConfirmationModal));
        Assertions.assertTrue(cartPage.orderConfirmationModal.isDisplayed());
    }

    @Then("I logOut from Demoblaze")
    public void iLogOutFromDemoblaze() throws InterruptedException {
        homePage.init();
        homePage.logOutButton.click();
        Thread.sleep(4000);
    }

    @And("I Add multiple products from the {string} product page.")
    public void iAddMultipleProductsFromTheProductPage(String arg0) throws InterruptedException {
        ProductActions.multipleProductsToCart(arg0);

    }
}
