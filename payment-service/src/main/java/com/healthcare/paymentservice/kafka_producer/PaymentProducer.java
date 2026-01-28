package com.healthcare.paymentservice.kafka_producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    // KafkaTemplate is used to send messages to Kafka topics
    private final KafkaTemplate<String, String> kafkaTemplate;

    // Constructor injection of KafkaTemplate
    public PaymentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Sends a payment success event to Kafka
    public void sendPaymentSuccess(String email) {

        // Publish the email/message to the 'payment-events' Kafka topic
        kafkaTemplate.send("payment-events", email);
    }
}

