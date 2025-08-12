package com.marufrobin.marufstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("strip")
@Primary
public class StripPaymentService implements PaymentService {
    @Value("${stripe.apiurl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean stripeEnabled;

    /// "${stripe.timeout:3000}" this means that if we don't give any value
    /// then it will give default value 3000
    @Value("${stripe.timeout:3000}")
    private int stripeTimeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrency;

    
    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe apiUrl: " + apiUrl);
        System.out.println("Stripe enabled: " + stripeEnabled);
        System.out.println("Stripe timeout: " + stripeTimeout);
        System.out.println("Stripe supported currencies: " + supportedCurrency);
        System.out.println("STRIPE");
        System.out.println("amount: " + amount);
    }
}
