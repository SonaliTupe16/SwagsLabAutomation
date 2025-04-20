package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.DriverFactory;

import static org.testng.Assert.assertTrue;

public class CheckoutSteps {

WebDriver driver;

	
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

	}
    CheckoutPage checkoutPage= new CheckoutPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage= new ProductsPage(driver);
    HomePage homePage= new HomePage(driver);

    @Given("user logs in for checkout with username {string} and password {string}")
    public void login(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        //productsPage = loginPage.clickLogin();
        homePage = loginPage.clickLogin();

    }

    @When("user adds a product to cart")
    public void addProduct() {
        productsPage.addFirstProductToCart();
    }

    @And("proceeds to checkout and fills info")
    public void proceedToCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.goToCartAndCheckout();
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.completePurchase();
    }
    @Then("order should be placed successfully")
    public void verifyOrder() {
        assertTrue(checkoutPage.isOrderConfirmed(), "Order confirmation message not found!");    
}             }
