package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.xpath("//h3");
    By menuBtn = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMsg).getText();
    }

    public void logout() {
        driver.findElement(menuBtn).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        driver.findElement(logoutLink).click();
    }
}