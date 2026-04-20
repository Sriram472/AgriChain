package com.example.agrichaint_pm.service;

import com.example.agrichaint_pm.dto.PaymentRequest;
import com.example.agrichaint_pm.entity.Payment;
import com.example.agrichaint_pm.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment initiatePayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setTransactionId(request.getTransactionId());
        payment.setMethod(request.getMethod());
        payment.setDate(LocalDateTime.now());
        payment.setStatus("Initiated");
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentStatus(Long id, String status) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
}