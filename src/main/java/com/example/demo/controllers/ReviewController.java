package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Review;
import com.example.demo.models.User;
import com.example.demo.services.impl.BookServiceImpl;
import com.example.demo.services.impl.ReviewServiceImpl;
import com.example.demo.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/vote")
    public ResponseEntity<?> reviewCreate(@RequestParam("username") String username,
                                          @RequestParam("bookId") Long id,
                                          @RequestParam("score") float score,
                                          @RequestParam("comment") String comment){
        User user = userService.findUserByUsername(username);
        Book book = bookService.findBookById(id);
        Review review = new Review();
        review.setBook(book);
        review.setUser(user);
        review.setScore(score);
        review.setComment(comment);
        user.getReviews().add(review);
        book.getReviews().add(review);
        book.setRating((float)book.getReviews().stream().mapToDouble(item -> item.getScore()).average().orElse(0f));
        return ResponseEntity.ok(reviewService.save(review));
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                bookService.findBookById(id)
        );
    }
    @GetMapping("/getUser/{username}")
    public ResponseEntity<?> getBook(@PathVariable("username") String username){
        return ResponseEntity.ok(
                userService.findUserByUsername(username).getReviews()
                );
    }
}
