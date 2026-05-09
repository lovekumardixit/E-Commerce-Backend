package com.ecommerce.order.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @PostMapping
    public Map<String, String> placeOrder() { return Map.of("status", "ORDER_PLACED", "event", "order.created"); }
    @PostMapping("/{id}/cancel")
    public Map<String, String> cancel(@PathVariable String id) { return Map.of("orderId", id, "status", "CANCELLED"); }
}
