package com.example.agrichaint_pm.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long transactionId;
    private String method; // Bank / Wallet
    private LocalDateTime date;
    private String status;

    // getters and setters
}