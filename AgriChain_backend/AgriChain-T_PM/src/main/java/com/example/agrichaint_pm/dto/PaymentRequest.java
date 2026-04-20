package com.example.agrichaint_pm.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long transactionId;
    private String method; // Bank / Wallet

    // getters and setters
}