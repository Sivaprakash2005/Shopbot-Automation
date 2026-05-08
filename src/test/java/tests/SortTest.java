package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class SortTest extends BaseTest {

    @Test(priority = 1)
    public void sortNameAZTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );

        ProductPage pp = new ProductPage(driver);

        pp.sortNameAZ();

        Assert.assertEquals(
                pp.getFirstProductName(),
                "Sauce Labs Backpack"
        );
    }

    @Test(priority = 2)
    public void sortNameZATest() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );

        ProductPage pp = new ProductPage(driver);

        pp.sortNameZA();

        Assert.assertEquals(
                pp.getFirstProductName(),
                "Test.allTheThings() T-Shirt (Red)"
        );
    }

    @Test(priority = 3)
    public void sortPriceLowToHighTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );

        ProductPage pp = new ProductPage(driver);

        pp.sortPriceLowToHigh();

        Assert.assertEquals(
                pp.getFirstProductPrice(),
                "$7.99"
        );
    }

    @Test(priority = 4)
    public void sortPriceHighToLowTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );

        ProductPage pp = new ProductPage(driver);

        pp.sortPriceHighToLow();

        Assert.assertEquals(
                pp.getFirstProductPrice(),
                "$49.99"
        );
    }

    @Test(priority = 5)
    public void productDetailValidationTest() {

        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );

        ProductPage pp = new ProductPage(driver);

        String productName = pp.getFirstProductName();

        String productPrice = pp.getFirstProductPrice();

        pp.openFirstProduct();

        Assert.assertEquals(
                pp.getDetailProductName(),
                productName
        );

        Assert.assertEquals(
                pp.getDetailProductPrice(),
                productPrice
        );
    }
}