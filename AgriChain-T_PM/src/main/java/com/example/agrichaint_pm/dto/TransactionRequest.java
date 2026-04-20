package com.example.agrichaint_pm.dto;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long orderId;
    private Double amount;

    // getters and setters
}