package com.healthcare.paymentservice.controller;

import com.healthcare.paymentservice.dto.ProductRequest;
import com.healthcare.paymentservice.dto.StripeResponse;
import com.healthcare.paymentservice.kafka_producer.PaymentProducer;
import com.healthcare.paymentservice.service.StripeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {

    private final StripeService stripeService;
    private final PaymentProducer paymentProducer;

    public ProductCheckoutController(StripeService stripeService, PaymentProducer paymentProducer) {

        this.stripeService = stripeService;
        this.paymentProducer = paymentProducer;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkout(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(stripeService.checkoutProducts(request));
    }

    // ✅ PAYMENT SUCCESS → KAFKA EVENT
    @GetMapping("/success")
    public String success(@RequestParam String email) {

        // trigger Kafka producer
        paymentProducer.sendPaymentSuccess(email);

        return "Payment successful";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "Payment cancelled";
    }
}

