package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.aop.ValidParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId) {
        // Logic to retrieve order by ID
        return "Order details for ID " + orderId;
    }


    @GetMapping("/save")
    @ValidParams
    public OrderDto saveOrder(@RequestBody OrderDto dto) {
        // Logic to retrieve order by ID
        return dto;
    }


    // Add other CRUD operations here
}