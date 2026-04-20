package com.example.agrichaint_pm.service;

import com.example.agrichaint_pm.dto.PaymentRequest;
import com.example.agrichaint_pm.entity.Payment;

public interface PaymentService {
    Payment initiatePayment(PaymentRequest request);
    Payment updatePaymentStatus(Long id, String status);
}