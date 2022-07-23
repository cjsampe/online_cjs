package com.online.online.service;

import com.online.online.domain.Order;
import com.online.online.domain.Product;
import com.online.online.domain.User;
import com.online.online.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;



    @Override
    public void addOrder(Product product, User user) {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setQuantity(1);
        order.setProduct(product);
        order.setUser(user);
        orderRepository.save(order);

    }

    @Override
    public List<Order> findOrders(User user) {
        //Listar
        return orderRepository.findByUser(user);
    }
}
