package com.example.demo.services.impl;

import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.OrderService;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Mapper mapper;


    @Override
    public Order createOrder(User user, OrderDetail orderDetail){
        Optional<Order> order = orderRepository.findOrderByUsername(user.getUsername());
        Order order1;
        if(order.isPresent()){
            order1 = order.get();
            order1.getOrderDetails().add(orderDetail);
            order1.setTotal((float) order1.getOrderDetails().stream().mapToDouble(ord -> ord.getUnitPrice()).sum());
            orderDetail.setOrder(order1);
        }
        else{
            order1 = new Order();
            order1.setUser(user);
            order1.setCreated(new Date());
            order1.getOrderDetails().add(orderDetail);
            order1.setTotal((float) order1.getOrderDetails().stream().mapToDouble(ord -> ord.getUnitPrice()).sum());
            orderDetail.setOrder(order1);
        }
        return orderRepository.save(order1);
    }

    @Override
    public Optional<Order> findOrderByUsername(String username){
        return orderRepository.findOrderByUsername(username);
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return orderRepository.findById(aLong);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
