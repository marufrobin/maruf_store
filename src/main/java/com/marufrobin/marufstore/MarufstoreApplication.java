package com.marufrobin.marufstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarufstoreApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MarufstoreApplication.class, args);
        var orderService = new OrderService(new PayPalPaymentService());
        orderService.placeOrder();
    }

}
