package com.sqa.payment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    // Locator
    By checkoutBtn = By.id("checkout");

    // Action
    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();
    }
}