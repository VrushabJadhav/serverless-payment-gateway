package com.sqa.payment;

import com.sqa.payment.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {

        boolean result = paymentService.processPayment(request.getAmount());

        if (result) {
            return ResponseEntity.ok("Payment Successful");
        } else {
            return ResponseEntity.status(500).body("Payment Failed");
        }
    }
}