package com.marufrobin.marufstore;

import org.springframework.stereotype.Service;

public interface PaymentService {
    void processPayment(double amount);
}
