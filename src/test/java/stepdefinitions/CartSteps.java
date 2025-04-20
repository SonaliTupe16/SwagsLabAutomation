package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

import static org.testng.Assert.assertTrue;

public class CartSteps {

WebDriver driver;

	
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

	}    
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productPage=new ProductsPage(driver);
    HomePage homePage=new HomePage(driver);

    @Given("user is logged in with username {string} and password {string}") // reuse same step
    public void login(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        //productsPage = loginPage.clickLogin();
        homePage = loginPage.clickLogin();

    }

    @When("user adds the first product to the cart")
    public void add_product() {
        productPage.addFirstProductToCart();
    }

    @Then("the cart icon should show 1 item")
    public void verify_cart() {
        assertTrue(productPage.isProductAddedToCart(), "Cart item count is incorrect");
    }
}

