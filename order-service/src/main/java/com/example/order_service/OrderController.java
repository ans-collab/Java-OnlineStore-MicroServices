package com.example.order_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController 
@RequestMapping ("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping 
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
    
    @GetMapping("/{userId}") // This endpoint retrieves all orders for a specific user based on their userId
    public List<Order> getOrder(@PathVariable Long userId) { // This method retrieves all orders for a specific user based on their userId
        return orderRepository.findByUserId(userId);
    }
    
}
