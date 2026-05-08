package tests;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void standardUserLoginTest() {

        LoginPage lp=new LoginPage(driver);
        lp.login(ConfigReader.getProperty("standard.username"), ConfigReader.getProperty("common.password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 2)
    public void lockedUserLoginTest() {
        LoginPage lp=new LoginPage(driver);
        lp.login(ConfigReader.getProperty("locked.username"), ConfigReader.getProperty("common.password"));
        Assert.assertTrue(lp.getErrorMessage().contains("locked out"));
    }

    @Test(priority = 3)
    public void problemUserLoginTest() {
        LoginPage lp=new LoginPage(driver);
        lp.login(ConfigReader.getProperty("problem.username"), ConfigReader.getProperty("common.password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 4)
    public void performanceUserLoginTest() {
        LoginPage lp=new LoginPage(driver);
        lp.login(ConfigReader.getProperty("performance.username"), ConfigReader.getProperty("common.password"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 5)
    public void errorUserLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.getProperty("error.username"), ConfigReader.getProperty("common.password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 6)
    public void visualUserLoginTest() {
        LoginPage lp=new LoginPage(driver);
        lp.login(ConfigReader.getProperty("visual.username"),ConfigReader.getProperty("common.password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 7)
    public void invalidLoginTest() {
        LoginPage lp=new LoginPage(driver);
        lp.login("wrong","wrong");
        Assert.assertTrue(lp.getErrorMessage().length() > 0);
    }

    @Test(priority = 8)
    public void logoutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.getProperty("standard.username"), ConfigReader.getProperty("common.password"));
        lp.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
}