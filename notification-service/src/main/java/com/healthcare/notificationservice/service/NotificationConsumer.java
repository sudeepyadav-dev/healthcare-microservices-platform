package com.healthcare.notificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "payment-events",
            groupId = "notification-group"
    )
    public void consumeMessage(String message) {

        // This method is automatically called when a message is received
        System.out.println("Received Kafka Message: " + message);

        // Here we can add email or other notification logic
    }
}