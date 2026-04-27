package com.saucedemo.tests;

import com.saucedemo.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isInventoryListDisplayed(),
                "Inventory list should be displayed after login");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_password");

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message should appear for invalid credentials");
    }

    @Test
    public void emptyCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message should appear for empty credentials");
    }
}