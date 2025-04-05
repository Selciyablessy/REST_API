package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private  TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository)
    {
        this.transactionRepository=transactionRepository;
    }

    public List<Transaction> getAllTransactions()
    {
        return transactionRepository.findAll();
    }

     public Transaction getTransactionById(Long id)
    {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction)
    {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id)
    {
        transactionRepository.deleteById(id);
    } 

   public Transaction updateTransaction(Long id,Transaction transaction)
    {
       transaction.setId(id);
       return transactionRepository.save(transaction);   
    
    }
}