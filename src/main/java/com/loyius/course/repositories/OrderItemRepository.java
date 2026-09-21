package com.loyius.course.repositories;

import com.loyius.course.entities.OrderItem;
import com.loyius.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
