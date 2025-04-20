package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

 // Constructor to initialize driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLogin() {
        driver.findElement(loginButton).click();
        return new HomePage(driver); // Assuming HomePage class handles post-login checks
    }
}
