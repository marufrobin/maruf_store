package com.marufrobin.marufstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    ///  if we have multiple constructor then AutoWired is important
    /// in single constructor doesn't really need it
//    @Autowired
    public OrderService(@Qualifier("paypal") PaymentService paymentService, @Qualifier("sms") NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }


    public void placeOrder() {
        paymentService.processPayment(10);
        notificationService.sendNotification();

    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
