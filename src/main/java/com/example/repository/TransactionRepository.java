package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    
} 