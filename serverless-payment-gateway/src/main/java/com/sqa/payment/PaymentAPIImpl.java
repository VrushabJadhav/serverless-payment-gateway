package com.sqa.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentAPIImpl implements PaymentAPI {

    @Override
    public boolean process(double amount) {
        if (amount > 0) {
            return true;
        }
        return false;
    }
}