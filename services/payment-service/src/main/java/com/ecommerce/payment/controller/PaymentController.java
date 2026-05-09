package com.ecommerce.payment.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @PostMapping("/charge")
    public Map<String, String> charge() { return Map.of("status", "SUCCESS", "transactionId", "txn-demo"); }
    @PostMapping("/{id}/refund")
    public Map<String, String> refund(@PathVariable String id) { return Map.of("transactionId", id, "status", "REFUND_INITIATED"); }
}
