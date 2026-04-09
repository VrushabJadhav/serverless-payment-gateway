package com.sqa.payment;

public class PaymentService {

    private PaymentAPI paymentAPI;

    public PaymentService(PaymentAPI paymentAPI){
        this.paymentAPI = paymentAPI;
    }

    public boolean processPayment(double amount){
        return paymentAPI.process(amount);
    }
}