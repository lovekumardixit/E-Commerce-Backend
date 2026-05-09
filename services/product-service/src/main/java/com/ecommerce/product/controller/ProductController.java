package com.ecommerce.product.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping
    public Map<String, Object> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size, @RequestParam(required = false) String q) {
        return Map.of("page", page, "size", size, "query", q, "items", List.of());
    }

    @PostMapping
    public Map<String, String> create() { return Map.of("status", "created"); }
}
