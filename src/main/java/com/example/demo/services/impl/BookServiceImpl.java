package com.example.demo.services.impl;

import com.example.demo.dto.BookDTO;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.services.BookService;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(BookDTO bookDTO){
        return bookRepository.save(mapper.toBook(bookDTO));
    }

    @Override
    public Book findBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
