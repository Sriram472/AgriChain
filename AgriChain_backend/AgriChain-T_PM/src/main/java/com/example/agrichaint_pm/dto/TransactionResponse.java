package com.example.agrichaint_pm.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private Long transactionId;
    private Long orderId;
    private Double amount;
    private String status;
    private LocalDateTime date;
}