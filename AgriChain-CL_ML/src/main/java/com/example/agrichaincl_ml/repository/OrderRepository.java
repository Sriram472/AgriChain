package com.example.agrichaincl_ml.repository;

import com.example.agrichaincl_ml.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByTraderId(Long traderId);
}