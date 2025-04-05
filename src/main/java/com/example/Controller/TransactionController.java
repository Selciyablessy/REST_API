package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Transaction;
import com.example.demo.Service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private  TransactionService transactionService;

    
    public TransactionController(TransactionService transactionService)
    {
        this.transactionService=transactionService;
    }
    
    @GetMapping
    public List<Transaction> getAllTransactions()
    {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction)
    {
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id)
    {
        transactionService.deleteTransaction(id);
        return "Transaction "+id+" has been deleted successfully ";

    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id,@RequestBody Transaction transaction)
    {
        return transactionService.updateTransaction(id, transaction);
    }

}

