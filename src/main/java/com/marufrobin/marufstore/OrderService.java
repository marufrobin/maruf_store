package com.marufrobin.marufstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;

    ///  if we have multiple constructor then AutoWired is important
    /// in single constructor doesn't really need it
//    @Autowired
    public OrderService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    public void placeOrder() {
        paymentService.processPayment(10);

    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
