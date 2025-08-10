package com.marufrobin.marufstore;

public class StripPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("amount: " + amount);
    }
}
