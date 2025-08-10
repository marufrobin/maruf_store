package com.marufrobin.marufstore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("strip")
@Primary
public class StripPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("amount: " + amount);
    }
}
