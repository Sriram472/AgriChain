package com.example.agrichaint_pm.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long orderId;
    private Double amount;
    private LocalDateTime date;
    private String status;

    // getters and setters
}