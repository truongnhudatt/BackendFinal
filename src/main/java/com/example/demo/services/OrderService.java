package com.example.demo.services;

import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order createOrder(User user, OrderDetail orderDetail);

    Optional<Order> findOrderByUsername(String username);

    Optional<Order> findById(Long aLong);

    List<Order> findAll();
}
