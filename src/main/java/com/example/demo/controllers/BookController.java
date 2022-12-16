package com.example.demo.controllers;


import com.example.demo.services.impl.BookServiceImpl;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private Mapper mapper;
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                mapper.toBookResponse(bookService.findBookById(id))
        );
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBook(){
        return ResponseEntity.ok(
                bookService.findAll().stream().map(book -> mapper.toBookResponse(book)).collect(Collectors.toList())
        );
    }

}
