package com.ecommerce.order.service;

import com.ecommerce.order.entity.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderWorkflowService {
    public Map<String, String> place(String orderId) {
        return Map.of("orderId", orderId, "status", OrderStatus.PENDING.name(), "nextEvent", "payment.initiate");
    }
    public Map<String, String> markPaid(String orderId) {
        return Map.of("orderId", orderId, "status", OrderStatus.PAID.name(), "nextEvent", "inventory.deduct");
    }
}
