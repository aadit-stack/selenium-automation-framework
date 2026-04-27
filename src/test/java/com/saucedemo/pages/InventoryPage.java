package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    WebDriver driver;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public boolean isInventoryListDisplayed() {
        return inventoryList.isDisplayed();
    }

    public void addBackpackToCart() {
        addBackpackToCart.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}