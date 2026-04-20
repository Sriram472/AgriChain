package com.example.agrichaint_pm.service;

import com.example.agrichaint_pm.dto.TransactionRequest;
import com.example.agrichaint_pm.entity.Transaction;
import com.example.agrichaint_pm.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(TransactionRequest request) {
        Transaction tx = new Transaction();
        tx.setOrderId(request.getOrderId());
        tx.setAmount(request.getAmount());
        tx.setDate(LocalDateTime.now());
        tx.setStatus("Pending");
        return transactionRepository.save(tx);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElseThrow();
    }
}