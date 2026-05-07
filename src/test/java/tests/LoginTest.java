package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.get("standard.username"),ConfigReader.get("standard.password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @Test
    public void lockedUserTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.get("locked.username"), ConfigReader.get("locked.password"));
        Assert.assertTrue(lp.getErrorMessage().contains("locked out"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong","wrong");
        Assert.assertTrue(lp.getErrorMessage().length()> 0);
    }

    @Test
    public void logoutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.get("standard.username"), ConfigReader.get("standard.password"));
        lp.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
}