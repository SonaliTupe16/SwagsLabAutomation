package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    
    //class="btn_action checkout_button"
    private By cartIcon = By.className("shopping_cart_link");
    private By checkoutBtn = By.cssSelector(".btn_action.checkout_button");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueBtn = By.cssSelector(".btn_primary.cart_button");
    private By finishBtn = By.cssSelector(".btn_action.cart_button");
    private By confirmationMsg = By.className("complete-header");

    public void goToCartAndCheckout() {
        driver.findElement(cartIcon).click();
        driver.findElement(checkoutBtn).click();
    }

    public void fillCheckoutInfo(String fname, String lname, String zip) {
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))
        );

        
        firstNameField.sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void completePurchase() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(finishBtn)
        );
        
        driver.findElement(finishBtn).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(confirmationMsg).getText().contains("THANK YOU");
    }
}

