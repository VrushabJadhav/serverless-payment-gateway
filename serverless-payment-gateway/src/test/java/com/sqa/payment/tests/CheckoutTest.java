package com.sqa.payment.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import com.sqa.payment.pages.*;
import com.sqa.payment.utils.DriverFactory;

public class CheckoutTest {

	@Test
	void testCheckoutFlow() throws InterruptedException {

	    WebDriver driver = DriverFactory.getDriver();
	    driver.get("https://www.saucedemo.com");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    LoginPage login = new LoginPage(driver);
	    login.login("standard_user", "secret_sauce");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));

	    ProductPage product = new ProductPage(driver);
	    product.addToCart();

	    wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));

	    product.goToCart();

	    Thread.sleep(1000);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));

	    CheckoutPage checkout = new CheckoutPage(driver);
	    checkout.clickCheckout();

	    driver.quit();
	}
}