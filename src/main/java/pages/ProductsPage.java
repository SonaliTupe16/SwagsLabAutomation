package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
	
    private By addToCartButtons = By.cssSelector(".inventory_item .btn_inventory");
    private By cartBadge = By.className("shopping_cart_badge");

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By sortDropdown = By.className("product_sort_container");
    private By productPrices = By.className("inventory_item_price");
    private By productNames = By.className("inventory_item_name");

    public void sortBy(String option) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }

    public List<Double> getProductPrices() {
        List<WebElement> prices = driver.findElements(productPrices);
        List<Double> priceList = new ArrayList<>();
        for (WebElement p : prices) {
            priceList.add(Double.parseDouble(p.getText().replace("$", "")));
        }
        return priceList;
    }

    public List<String> getProductNames() {
        List<WebElement> names = driver.findElements(productNames);
        List<String> productList = new ArrayList<>();
        for (WebElement name : names) {
            productList.add(name.getText());
        }
        return productList;
    }
    

    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    public boolean isProductAddedToCart() {
        return driver.findElement(cartBadge).getText().equals("1");
    }

}
