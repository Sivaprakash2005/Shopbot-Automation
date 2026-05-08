package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By products = By.className("inventory_item");
    By addCart = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartBadge = By.className("shopping_cart_badge");
    By sortDropdown = By.className("product_sort_container");
    By productNames = By.className("inventory_item_name");
    By productPrices = By.className("inventory_item_price");
    By firstProduct = By.className("inventory_item_name");

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

    public void sortNameAZ() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (A to Z)");
    }

    public void sortNameZA() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (Z to A)");
    }

    public void sortPriceLowToHigh() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Price (low to high)");
    }

    public void sortPriceHighToLow() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Price (high to low)");
    }

    public String getFirstProductName() {
        List<WebElement> list = driver.findElements(productNames);
        return list.get(0).getText();
    }

    public String getFirstProductPrice() {
        List<WebElement> list = driver.findElements(productPrices);
        return list.get(0).getText();
    }

    public void openFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public String getDetailProductName() {
        return driver.findElement(By.className("inventory_details_name")).getText();
    }

    public String getDetailProductPrice() {
        return driver.findElement(By.className("inventory_details_price")).getText();
    }
}