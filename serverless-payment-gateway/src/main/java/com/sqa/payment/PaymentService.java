package com.sqa.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sqa.payment.metrics.PaymentMetrics;

@Service
public class PaymentService {

    private PaymentAPI paymentAPI;

    @Autowired
    private PaymentMetrics paymentMetrics;

    public PaymentService(PaymentAPI paymentAPI){
        this.paymentAPI = paymentAPI;
    }

    public boolean processPayment(double amount){

        // 🔴 RED - Requests
        paymentMetrics.incrementRequests();

        try {
            // 🔴 RED - Duration
            return paymentMetrics.recordDuration(() -> {

                if (amount <= 0) {
                    throw new RuntimeException("Invalid payment amount");
                }

                return paymentAPI.process(amount);
            });

        } catch (Exception e) {

            // 🔴 RED - Errors
            paymentMetrics.incrementErrors();

            return false;
        }
    }
}