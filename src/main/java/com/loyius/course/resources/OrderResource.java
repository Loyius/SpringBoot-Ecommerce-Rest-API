package com.loyius.course.resources;

import com.loyius.course.entities.Order;
import com.loyius.course.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    private final OrderService service;

    public OrderResource(OrderService service) { this.service = service;}

    @GetMapping
    public ResponseEntity<List<Order>> getlOrders() {
        List<Order> list = service.getOrders();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long id) {
        Order obj = service.getOrderById(id);
        if(obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }
}
