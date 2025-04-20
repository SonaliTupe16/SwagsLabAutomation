package stepdefinitions;

	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

	import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.ProductsPage;
import pages.HomePage;
	import utils.DriverFactory;

	public class LoginSteps {

		WebDriver driver;

		
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();

		}
	    LoginPage loginPage = new LoginPage(driver);
	    HomePage homePage = new HomePage(driver);



	    @Given("user is on the login page")
	    public void user_on_login_page() {
	        driver.get("https://www.saucedemo.com/v1/");
	    }

	    @When("user enters username {string} and password {string}")
	    public void enter_credentials(String username, String password) {
	        loginPage.enterUsername(username);
	        loginPage.enterPassword(password);
	    }

	    @And("clicks on the login button")
	    public void click_login() {
	        homePage = loginPage.clickLogin();
	    }

	    @Then("homepage should be displayed")
	    public void verify_homepage() {
	        Assert.assertTrue(homePage.isPageDisplayed());
	    }
	}
	


