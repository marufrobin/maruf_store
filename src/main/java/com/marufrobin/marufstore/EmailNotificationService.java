package com.marufrobin.marufstore;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Email Notification Service");
    }
}
