package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartIcon = By.className("shopping_cart_link");
    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By confirmationMsg = By.className("complete-header");
    By totalPrice = By.className("summary_total_label");

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    public void enterCheckoutDetails(String fname,String lname, String zip) {

        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMsg).getText();
    }
}