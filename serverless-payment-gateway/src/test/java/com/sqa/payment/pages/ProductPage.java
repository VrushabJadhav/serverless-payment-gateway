package com.sqa.payment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By firstProduct = By.className("inventory_item_name");
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    // Actions
    public void selectProduct(){
        driver.findElement(firstProduct).click();
    }

    public void addToCart(){
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart(){
        driver.findElement(cartIcon).click();
    }
}