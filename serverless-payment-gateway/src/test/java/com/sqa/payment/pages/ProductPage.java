package com.sqa.payment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    // ✅ Add to cart directly from inventory page
    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    // No need to click product anymore
    public void addToCart(){
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart(){
        driver.findElement(cartIcon).click();
    }
}