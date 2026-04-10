package com.sqa.payment.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

@Component
public class PaymentMetrics {

    private final Counter requestCounter;
    private final Counter errorCounter;
    private final Timer durationTimer;

    public PaymentMetrics(MeterRegistry meterRegistry) {

        this.requestCounter = Counter.builder("payment_requests_total")
                .description("Total payment requests")
                .register(meterRegistry);

        this.errorCounter = Counter.builder("payment_errors_total")
                .description("Total failed payment requests")
                .register(meterRegistry);

        this.durationTimer = Timer.builder("payment_duration_seconds")
                .description("Payment processing duration")
                .register(meterRegistry);
    }

    public void incrementRequests() {
        requestCounter.increment();
    }

    public void incrementErrors() {
        errorCounter.increment();
    }

    public <T> T recordDuration(java.util.concurrent.Callable<T> callable) throws Exception {
        return durationTimer.recordCallable(callable);
    }
}