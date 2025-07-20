package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public String getTransactions (ModelMap model) {
        List<Transaction> transactions = transactionService.findAll();
        transactions.sort(Comparator.comparing(Transaction::getDate));
        model.put("transactions", transactions);
        return "transactions";
    }
    @GetMapping("/transactions/{transactionId}")
    public String getTransactionDetails (@PathVariable Integer transactionId, ModelMap model) {
        Transaction transaction = transactionService.findById(transactionId);
        model.put("transaction", transaction);
        return "transaction";
    }
}
