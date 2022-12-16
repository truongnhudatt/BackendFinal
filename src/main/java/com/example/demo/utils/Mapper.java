package com.example.demo.utils;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.models.Book;
import com.example.demo.models.Order;
import com.example.demo.models.OrderDetail;
import com.example.demo.models.User;
import com.example.demo.payload.response.BookResponse;
import com.example.demo.payload.response.OrderDetailResponse;
import com.example.demo.payload.response.OrderResponse;
import com.example.demo.payload.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {

    public UserDTO toDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    public User toUser(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
//        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getRole());
        return user;
    }

    public UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

    public BookResponse toBookResponse(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setDescription(book.getDescription());
        bookResponse.setTypeBook(book.getTypeBook());
        bookResponse.setDateRelease(book.getDateRelease());
        bookResponse.setTotalPage(book.getTotalPage());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setRating(book.getRating());
        return bookResponse;
    }

    public Book toBook(BookDTO bookDTO){
//        BookResponse bookResponse = new BookResponse();
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setTypeBook(bookDTO.getTypeBook());
        book.setDateRelease(bookDTO.getDateRelease());
        book.setTotalPage(bookDTO.getTotalPage());
        book.setPrice(bookDTO.getPrice());
        return book;
    }

    public OrderResponse toOrderResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setUsername(order.getUser().getUsername());
        orderResponse.setOrderDetailResponses(order.getOrderDetails().stream().map(item -> this.toOrderDetailResponse(item)).collect(Collectors.toList()));
        System.out.println(orderResponse.getOrderDetailResponses());
        orderResponse.setTotal(order.getTotal());
        orderResponse.setCreated(order.getCreated());
        return  orderResponse;
    }

    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail){
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId(orderDetail.getId());
        orderDetailResponse.setBookResponse(this.toBookResponse(orderDetail.getBook()));
        orderDetailResponse.setQuantity(orderDetail.getQuantity());
        orderDetailResponse.setUnitPrice(orderDetail.getUnitPrice());
        orderDetailResponse.setPrice(orderDetail.getPrice());
        return orderDetailResponse;
    }

}
