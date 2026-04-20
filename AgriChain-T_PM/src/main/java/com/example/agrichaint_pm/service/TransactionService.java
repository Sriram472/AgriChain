package com.example.agrichaint_pm.service;

import com.example.agrichaint_pm.dto.TransactionRequest;
import com.example.agrichaint_pm.entity.Transaction;

public interface TransactionService {
    Transaction createTransaction(TransactionRequest request);
    Transaction getTransaction(Long id);
}