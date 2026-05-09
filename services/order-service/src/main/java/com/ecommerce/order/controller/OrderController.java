package com.ecommerce.order.controller;

import com.ecommerce.order.entity.OrderStatus;
import com.ecommerce.order.service.OrderWorkflowService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderWorkflowService workflowService;
    public OrderController(OrderWorkflowService workflowService) { this.workflowService = workflowService; }

    @PostMapping
    public Map<String, String> placeOrder(@RequestParam String orderId) { return workflowService.place(orderId); }

    @PostMapping("/{id}/status/{status}")
    public Map<String, String> updateStatus(@PathVariable String id, @PathVariable OrderStatus status) {
        return Map.of("orderId", id, "status", status.name());
    }

    @PostMapping("/{id}/cancel")
    public Map<String, String> cancel(@PathVariable String id) { return Map.of("orderId", id, "status", OrderStatus.CANCELLED.name()); }
}
