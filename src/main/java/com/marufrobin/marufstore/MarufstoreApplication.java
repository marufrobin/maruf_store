package com.marufrobin.marufstore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MarufstoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MarufstoreApplication.class, args);

        var orderService = context.getBean(OrderService.class);
//        var orderService = new OrderService();
//        orderService.setPaymentService(new PayPalPaymentService());
        orderService.placeOrder();

        NotificationManager notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Notification SEND");
    }

}
