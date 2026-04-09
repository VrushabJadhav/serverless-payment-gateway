package com.sqa.payment;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    @Test
    void testPaymentSuccess() {
        PaymentAPI mockAPI = mock(PaymentAPI.class);
        when(mockAPI.process(10.0)).thenReturn(true);

        PaymentService service = new PaymentService(mockAPI);

        assertTrue(service.processPayment(10.0));
    }

    @Test
    void testPaymentFailure() {
        PaymentAPI mockAPI = mock(PaymentAPI.class);
        when(mockAPI.process(10.0)).thenReturn(false);

        PaymentService service = new PaymentService(mockAPI);

        assertFalse(service.processPayment(10.0));
    }
}