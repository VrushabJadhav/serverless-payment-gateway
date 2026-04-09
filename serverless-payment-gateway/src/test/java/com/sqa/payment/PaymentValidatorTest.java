package com.sqa.payment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentValidatorTest {

    PaymentValidator validator = new PaymentValidator();

    @Test
    void testValidAmount() {
        assertTrue(validator.validateAmount(10.0));
    }

    @Test
    void testBelowMinimum() {
        assertFalse(validator.validateAmount(0.0005));
    }

    @Test
    void testAboveMaximum() {
        assertFalse(validator.validateAmount(150));
    }
}