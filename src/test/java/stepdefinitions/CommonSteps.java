package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

public class CommonSteps {
	
WebDriver driver;

	
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

	}
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    HomePage homePage = new HomePage(driver);
    
    @Given("user logs in with username {string} and password {string}")
    public void login(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        //productsPage = loginPage.clickLogin();
      homePage = loginPage.clickLogin();

        // shared login logic
    }
}
