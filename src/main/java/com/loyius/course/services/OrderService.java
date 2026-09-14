package com.loyius.course.services;

import com.loyius.course.entities.Order;
import com.loyius.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository orderRepository) {this.repository = orderRepository;}

    public List<Order> getOrders() { return repository.findAll();}

    public Order getOrderById(Long id){
        Optional<Order> order = repository.findById(id);
        return order.orElse(null);
    }
}
