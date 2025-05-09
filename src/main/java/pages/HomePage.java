package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By inventoryContainer = By.id("inventory_container");

    public boolean isPageDisplayed() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}
