package com.example.demo.services;

import com.example.demo.models.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OrderDetailService {
    <S extends OrderDetail> S save(S entity);

    Optional<OrderDetail> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(OrderDetail entity);
}
