package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test(priority = 1)
    public void checkoutFlowTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login(
                ConfigReader.getProperty("standard.username"),
                ConfigReader.getProperty("common.password")
        );
        ProductPage pp = new ProductPage(driver);
        pp.addProduct();
        CheckoutPage cp = new CheckoutPage(driver);
        cp.openCart();
        cp.clickCheckout();
        cp.enterCheckoutDetails("Siva", "Prakash", "600001");
        Assert.assertTrue(cp.getTotalPrice()
                .contains("Total")
        );

        cp.finishOrder();

        Assert.assertEquals(
                cp.getConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}