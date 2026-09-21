package com.loyius.course.repositories;

import com.loyius.course.entities.Order;
import com.loyius.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderItemPK> {

}
