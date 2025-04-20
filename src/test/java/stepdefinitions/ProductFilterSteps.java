package stepdefinitions;



import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductFilterSteps {

	
	WebDriver driver;

	
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

	}
	
	
   // WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    HomePage homePage = new HomePage(driver);
    

    @Given("user logs in to filter products with username {string} and password {string}")
    public void login_user(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        //productsPage = loginPage.clickLogin();
      homePage = loginPage.clickLogin();

    }

    @When("user sorts the products by {string}")
    public void user_sorts_products(String filterOption) {
        productsPage.sortBy(filterOption);
    }

    @Then("the product list should be displayed in ascending order")
    public void verify_sorted_products() {
        List<Double> prices = productsPage.getProductPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            assertTrue(prices.get(i) <= prices.get(i + 1), "Prices are not sorted");
        }
    }
}
