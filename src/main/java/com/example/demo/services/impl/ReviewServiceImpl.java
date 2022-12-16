package com.example.demo.services.impl;

import com.example.demo.models.Review;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    public <S extends Review> S save(S entity) {
        return reviewRepository.save(entity);
    }

    public Optional<Review> findById(Long aLong) {
        return reviewRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return reviewRepository.existsById(aLong);
    }

    public long count() {
        return reviewRepository.count();
    }

    public void deleteById(Long aLong) {
        reviewRepository.deleteById(aLong);
    }

    public void delete(Review entity) {
        reviewRepository.delete(entity);
    }
}
