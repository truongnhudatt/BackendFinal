package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.User;
import com.example.demo.payload.response.OrderResponse;
import com.example.demo.services.impl.BookServiceImpl;
import com.example.demo.services.impl.OrderServiceImpl;
import com.example.demo.services.impl.UserServiceImpl;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Mapper mapper;
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestParam("username") String username,
                                         @RequestParam("bookId") Long id,
                                         @RequestParam("quantity") int quantity){
        User user = userService.findUserByUsername(username);
        Book book = bookService.findBookById(id);
        if(user != null && book != null){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBook(book);
            orderDetail.setPrice(book.getPrice());
            orderDetail.setQuantity(quantity);
            orderDetail.setUnitPrice(book.getPrice()*orderDetail.getQuantity());
            return ResponseEntity.ok(mapper.toOrderResponse(orderService.createOrder(user, orderDetail)));
        };
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/detail/{username}")
    public ResponseEntity<?> getOrderByUsername(@PathVariable("username") String username){
        Optional<Order> order = orderService.findOrderByUsername(username);
        if(order.isPresent()){
            return ResponseEntity.ok(mapper.toOrderResponse(order.get()));
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(orderService.findAll().stream().map(order -> mapper.toOrderResponse(order)).collect(Collectors.toList()));
    }

}
