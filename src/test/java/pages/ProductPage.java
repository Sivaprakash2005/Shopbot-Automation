package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By products = By.className("inventory_item");
    By addCart = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartBadge = By.className("shopping_cart_badge");
    public int getProductCount() {
        List<WebElement> list = driver.findElements(products);
        return list.size();
    }

    public void addProduct() {
        driver.findElement(addCart).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }
}