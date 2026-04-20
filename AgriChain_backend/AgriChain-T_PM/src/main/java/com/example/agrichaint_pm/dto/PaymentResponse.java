package com.example.agrichaint_pm.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Long paymentId;
    private Long transactionId;
    private String method;
    private String status;
    private LocalDateTime date;
}