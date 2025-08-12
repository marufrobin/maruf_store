package com.marufrobin.marufstore;


import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification Service" + message);
    }
}
