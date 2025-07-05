package com.example.product_order_app.repository;

import com.example.product_order_app.data.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findOrderListByName(String productName);
}
