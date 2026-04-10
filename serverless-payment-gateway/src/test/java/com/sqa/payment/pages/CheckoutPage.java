package com.sqa.payment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sqa.payment.utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils wait;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    private By checkoutBtn = By.id("checkout");

    public void clickCheckout(){
        wait.waitForVisibility(checkoutBtn);
        wait.waitForClickable(checkoutBtn).click();
    }

    public void verifyCartPage(){
        wait.waitForUrlContains("cart");
    }
}