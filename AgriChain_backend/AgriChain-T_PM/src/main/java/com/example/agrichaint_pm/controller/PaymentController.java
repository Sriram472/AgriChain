package com.example.agrichaint_pm.controller;

import com.example.agrichaint_pm.dto.PaymentRequest;
import com.example.agrichaint_pm.entity.Payment;
import com.example.agrichaint_pm.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public Payment initiatePayment(@RequestBody PaymentRequest request) {
        return paymentService.initiatePayment(request);
    }

    @PutMapping("/{id}/status")
    public Payment updatePaymentStatus(@PathVariable Long id, @RequestParam String status) {
        return paymentService.updatePaymentStatus(id, status);
    }
}