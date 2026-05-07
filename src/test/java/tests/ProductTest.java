package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class ProductTest extends BaseTest {

    @Test
    public void productDisplayTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.get("standard.username"),ConfigReader.get("standard.password"));
        ProductPage pp=new ProductPage(driver);
        Assert.assertTrue(pp.getProductCount() > 0);
    }

    @Test
    public void addToCartTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(ConfigReader.get("standard.username"),ConfigReader.get("standard.password"));
        ProductPage pp = new ProductPage(driver);
        pp.addProduct();
        Assert.assertEquals(pp.getCartCount(),"1");
    }
}