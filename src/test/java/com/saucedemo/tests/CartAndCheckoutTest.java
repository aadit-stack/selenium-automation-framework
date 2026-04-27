package com.saucedemo.tests;

import com.saucedemo.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartAndCheckoutTest extends BaseTest {

    @Test
    public void addItemToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartBadgeCount(), "1",
                "Cart badge should show 1 item");
    }

    @Test
    public void completeCheckoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("Aadit");
        checkoutPage.enterLastName("Mishra");
        checkoutPage.enterPostalCode("400001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(checkoutPage.getOrderConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message should appear");
    }
}