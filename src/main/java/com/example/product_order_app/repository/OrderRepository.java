package com.example.product_order_app.repository;

import com.example.product_order_app.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryCustom{
}
