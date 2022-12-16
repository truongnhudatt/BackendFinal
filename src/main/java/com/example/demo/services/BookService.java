package com.example.demo.services;

import com.example.demo.dto.BookDTO;
import com.example.demo.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book save(BookDTO bookDTO);

    Book findBookById(Long id);

    List<Book> findAll();
}
