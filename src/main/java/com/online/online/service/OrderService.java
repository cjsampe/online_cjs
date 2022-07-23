package com.online.online.service;

import com.online.online.domain.Order;
import com.online.online.domain.Product;
import com.online.online.domain.User;

import java.util.List;

public interface OrderService {

    void addOrder(Product product, User user);
    List<Order> findOrders(User user);
}
