package com.sqa.payment.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.sqa.payment.pages.*;
import com.sqa.payment.utils.DriverFactory;

public class CheckoutTest {

    @Test
    void testCheckoutFlow() throws InterruptedException {

        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com");

        // Step 1: Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        Thread.sleep(2000);

        // Step 2: Select product
        ProductPage product = new ProductPage(driver);
        product.selectProduct();

        Thread.sleep(2000);

        // Step 3: Add to cart
        product.addToCart();

        Thread.sleep(2000);

        // Step 4: Go to cart
        product.goToCart();

        Thread.sleep(2000);

        // Step 5: Checkout
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickCheckout();

        Thread.sleep(2000);

        driver.quit();
    }
}