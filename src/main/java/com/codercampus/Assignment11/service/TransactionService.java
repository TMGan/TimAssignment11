package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    Integer transactionId = 1;

    @Autowired
    private TransactionRepository transactionRepo;


    public List<Transaction> findAll() {
        return transactionRepo.findAll();

    }

    public List<Transaction> getAllTransactionsSorted() {
    List<Transaction> transactions = transactionRepo.findAll();

    List<Transaction> sortedTransactions = transactions.stream()
            .sorted(Comparator.comparing(Transaction::getDate))
            .collect(Collectors.toList());
    return sortedTransactions;
    }

    public Transaction findById(Integer transactionId) {
        return transactionRepo.findById(transactionId);
    }
}
