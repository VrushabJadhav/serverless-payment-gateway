package com.sqa.payment;

public class PaymentValidator {

    public boolean validateAmount(double amount){
        if(amount < 0.001) return false;
        if(amount > 100) return false;
        return true;
    }
}